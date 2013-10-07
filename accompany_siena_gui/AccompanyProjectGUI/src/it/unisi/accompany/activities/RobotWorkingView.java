package it.unisi.accompany.activities;

import it.unisi.accompany.AccompanyGUIApp;
import it.unisi.accompany.AccompanyPreferences;
import it.unisi.accompany.threads.DrawingThread;
import it.unisi.accompany.threads.MaskAnimationThreadWorking;
import it.unisi.accompany.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout.LayoutParams;

@SuppressWarnings("deprecation")
public class RobotWorkingView extends Activity implements SurfaceHolder.Callback{
	
	protected final String TAG = "Accomapny GUI - working view";
	
	protected AccompanyGUIApp myApp;
	protected RobotWorkingView me;
	protected boolean toClose;
	
	protected AbsoluteLayout my_layout;
	public SurfaceView image;
	public ImageView mask,mask1,mask2,mask3,mask4,mask5,mask6,mask7,maskF;//,mask9,mask10;
	//public ImageView mask1s,mask2s,mask3s,mask4s,mask5s,mask6s,mask7s,mask8s;

	
	protected PopupWindow popupWindow;
	protected AccompanyPreferences myPreferences;
	
	protected ImageButton opt_menu;
	
	protected FrameLayout main_layout;
	protected PopupWindow menu;
	protected Button runningAction;
	
	protected Matrix my_matrix;
	
	protected final int MYRUNNINGWIDTH=100;
	protected final int MYRUNNINGTEXTSIZE=10;
	protected final int running_X=1100;
	protected final int running_Y=650;
	
	protected Handler animationHandler;
	protected MaskAnimationThreadWorking mt;
	
	protected ProgressDialog pdd = null;
	
	protected DrawingThread myThread;
	public int screen_w,screen_h;
	protected SurfaceHolder holder;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		//standrd things
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.new_rww);
		
		//recovering the application that owns this activity
		//and setting the activity variable -->LATER TO AVOID CRASHES
		myApp=(AccompanyGUIApp)this.getApplication();
		me=this;
		
		//bring camera to front
		if (myApp.head_controller!=null) myApp.head_controller.bringCameraToFront();
		if (myApp.torso_controller!=null) myApp.torso_controller.bringHome();
		
		//reading the preferences 
		myPreferences=new AccompanyPreferences(this);
		myPreferences.loadPreferences();
		
		 //Setting up the policies for the use of threads
        if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		image=(SurfaceView)this.findViewById(R.id.robot_working_image_view);
		holder = image.getHolder();
		holder.addCallback(this);
		
		try{
			//image.setImageBitmap(myApp.getLastImage());
		}catch(Exception e)
		{
			Log.w(TAG,"Attention: null robot image when going in working view!");
		}
		
		mask=(ImageView)this.findViewById(R.id.mask_basic_working);
		mask1=(ImageView)this.findViewById(R.id.mask_basic_working1);
		mask2=(ImageView)this.findViewById(R.id.mask_basic_working2);
		mask3=(ImageView)this.findViewById(R.id.mask_basic_working3);
		mask4=(ImageView)this.findViewById(R.id.mask_basic_working4);
		mask5=(ImageView)this.findViewById(R.id.mask_basic_working5);
		mask6=(ImageView)this.findViewById(R.id.mask_basic_working6);
		mask7=(ImageView)this.findViewById(R.id.mask_basic_working7);
		maskF=(ImageView)this.findViewById(R.id.mask_basic_workingF);
		//mask9=(ImageView)this.findViewById(R.id.mask_basic_working9);
		//mask10=(ImageView)this.findViewById(R.id.mask_basic_working10);
		/*mask1s=(ImageView)this.findViewById(R.id.mask_basic_1s);
		mask2s=(ImageView)this.findViewById(R.id.mask_basic_2s);
		mask3s=(ImageView)this.findViewById(R.id.mask_basic_3s);
		mask4s=(ImageView)this.findViewById(R.id.mask_basic_4s);
		mask5s=(ImageView)this.findViewById(R.id.mask_basic_5s);
		mask6s=(ImageView)this.findViewById(R.id.mask_basic_6s);
		mask7s=(ImageView)this.findViewById(R.id.mask_basic_7s);
		mask8s=(ImageView)this.findViewById(R.id.mask_basic_8s);*/
		
		opt_menu=(ImageButton)this.findViewById(R.id.optmenu);
	    opt_menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showMyMenu();
			}
		});
	    
	    main_layout=(FrameLayout)this.findViewById(R.id.robot_working_global_layout);
		
		Log.i("AccompanyGUI","on create robotWorkingView");
		myApp.setRunningActivity(myApp.EXECUTE_VIEW);
		
		animationHandler= new Handler();
	//	main_layout.addView(runningAction);
        
        //finally we register the activity on the app to be sure that everything is loaded and avoid crashes
        myApp.setRobotWorkingView(me);//this);
        
		runningAction=(Button)this.findViewById(R.id.current_working_action);
		runningAction.setText(myApp.getCurrentTask());	
		runningAction.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
	}
	
	@Override
	public void onRestart()
	{
		super.onRestart();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
        mt=new MaskAnimationThreadWorking(animationHandler, me);//this);
        mt.start();
    	//select the correct inital mask
		setMask();
		toClose=true;
		if (myThread!=null) myThread.restart();
	}
	
	public void refreshImage(Bitmap b)
	{
//		image.setImageBitmap(b);
	}
	
	/*public void refreshImage2(Bitmap b, Matrix m)
	{
		image.setImageBitmap(b);
		image.setImageMatrix(m);
		my_matrix=m;
		image.invalidate();
	}*/
	
	//Toast to send a short message on  the screen
	public Toast toastMessage(String msg)
	{
		CharSequence connessione = msg;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(getApplicationContext(), connessione, duration);
		toast.setGravity(Gravity.LEFT | Gravity.LEFT, 5, 5);
		toast.show();
		return toast; 
		    
	}
	
	//to switch to the user view we need to launch the correct activity
	public void switchToUserView()
	{
		mt.terminate();
		toClose=false;
		myApp.stopSubscribing();
		myApp.setDrawingThread(null);
		final Intent intent = new Intent().setClass(RobotWorkingView.this.me, UserView.class);
		RobotWorkingView.this.startActivity(intent);
		finish();
	}
	
	//Switching to robot view (on banners clicks), the robot view activity is launched:
	public void switchToRobotView()
	{
		mt.terminate();
		toClose=false;
		myApp.setDrawingThread(null);
		final Intent intent = new Intent().setClass(RobotWorkingView.this.me, RobotView.class);
		RobotWorkingView.this.startActivity(intent);
		finish();
	}
	
	//Switching to robot view (on banners clicks), the robot view activity is launched:
	public void switchToActionsList()
	{
		mt.terminate();
		myApp.stopSubscribing();
		toClose=false;
		myApp.setDrawingThread(null);
		final Intent intent = new Intent().setClass(RobotWorkingView.this.me, ActionsListView.class);
		RobotWorkingView.this.startActivity(intent);
		finish();
	}
	
	@Override
	public void onDestroy()
	{
		Log.e(TAG,"destroying...");
		if (pdd!=null) pdd.dismiss();
		if (menu!=null) menu.dismiss();
		if (mt!=null) 
		{
			try{
				mt.join();
			}catch(Exception e){
				Log.e(TAG,"Cannot join mask thread...");
			}
		}
		super.onDestroy();
	}
	
	 /****************************/
    /* the options menu methods */
    /****************************/
    @Override
    public boolean onCreateOptionsMenu(final android.view.Menu menu) {
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
		return super.onOptionsItemSelected(item);
    }
    
    public int getDisplayHeight()
    {
    	Display display = getWindowManager().getDefaultDisplay();
    	return display.getHeight();
    }
    
    public int getDisplayWidth()
    {
    	Display display = getWindowManager().getDefaultDisplay();
    	return display.getWidth();
    }
    
    public void closeOnError(String msg)
    {
    	pdd = ProgressDialog.show(this, getResources().getString(R.string.gui_title), msg);
		pdd.setIcon(android.R.drawable.ic_dialog_alert);
		Thread waiter = new Thread() {
			@Override
			public void run()
			{
				final int max_time=2000;  //5 secondi di attesa del servizo
				int waited=0;
				try{
					while (waited < max_time)
					{
						Thread.sleep(100);
						waited+=100;
					}
				} catch(final Exception e){
					
				}
				finally{  //if service is active send request to db
					pdd.dismiss();
					pdd=null;
					myApp.closeApp();
				}
			}
		};
		waiter.start();
    }
    
    /****************************/
    
	//to close this activity
	public void halt()
	{
		mt.terminate();
		this.finish();
	}

	protected void showMyMenu()
    {
    	LayoutInflater layoutInflater 
	     = (LayoutInflater)getBaseContext()
	      .getSystemService(LAYOUT_INFLATER_SERVICE);  
	    LinearLayout popupView =(LinearLayout)layoutInflater.inflate(R.layout.my_opt_menu, null);
	    Button act_btn=(Button)popupView.findViewById(R.id.act_btn);
	    act_btn.setWidth(this.getDisplayWidth()/4);
	    act_btn.setTextColor(Color.DKGRAY);
	    Button sett_btn=(Button)popupView.findViewById(R.id.Sett_btn);
	    sett_btn.setWidth(this.getDisplayWidth()/4);
	    sett_btn.setTextColor(Color.DKGRAY);
	    Button voice_btn=(Button)popupView.findViewById(R.id.voice_btn);
	    voice_btn.setWidth(this.getDisplayWidth()/4);
	    voice_btn.setTextColor(Color.DKGRAY);
	    if (myPreferences.getSpeechMode())
	    	voice_btn.setText("Voice Off");
	    else
	    	voice_btn.setText("Voice On");
	    Button close_btn=(Button)popupView.findViewById(R.id.Close_btn);
	    close_btn.setWidth(this.getDisplayWidth()/4);
	    menu = new PopupWindow(popupView,LayoutParams.MATCH_PARENT,100,true);
	    menu.setContentView(popupView);
		menu.setOutsideTouchable(true);
       	menu.setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent));
	    Log.e("aa",main_layout.getMeasuredHeight()+ " "+popupView.getHeight());
	    menu.showAtLocation(this.findViewById(R.id.robot_working_global_layout), 0, 0, (main_layout.getMeasuredHeight()-popupView.getHeight()));
	    close_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				LayoutInflater layoutInflater 
			     = (LayoutInflater)me.getBaseContext()
			      .getSystemService(me.LAYOUT_INFLATER_SERVICE);  
			    LinearLayout popupView =(LinearLayout)layoutInflater.inflate(R.layout.mypopupclose, null);	    
	       	popupView.setOrientation(popupView.VERTICAL);
	       	TextView ptv= new TextView(getApplicationContext());
	       	ptv.setBackgroundColor(Color.TRANSPARENT);
	       	ptv.setTextColor(Color.WHITE);
	       	ptv.setText("Close Activity");
	       	ptv.setTextSize(22);
	       	ptv.setPadding(10, 2, 2, 2);
	       	popupView.addView(ptv);
	       	Button line= new Button(getApplicationContext());
	   		line.setBackgroundColor(Color.WHITE);
	   		line.setClickable(false);
	   		line.setHeight(2);
	   		LinearLayout.LayoutParams p= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
	   				2);
	   		line.setLayoutParams(p);
	   		popupView.addView(line);
	   		TextView ptv2= new TextView(getApplicationContext());
	       	ptv2.setBackgroundColor(Color.TRANSPARENT);
	       	ptv2.setTextColor(Color.WHITE);
	       	ptv2.setText("Are you sure?");
	       	ptv2.setTextSize(18);
	       	ptv2.setPadding(10, 5, 0, 5);
	       	popupView.addView(ptv2);
	   		LinearLayout ll= new LinearLayout(getApplicationContext());
	   		ll.setBackgroundColor(Color.TRANSPARENT);
	   		ll.setOrientation(ll.HORIZONTAL);
	   		ll.setPadding(5, 5, 5, 5);
	   		ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
	       	popupView.addView(ll);
	       	Button yes= new Button(getApplicationContext());
	       	yes.setText("yes");
	       	yes.setWidth(125);
	       	yes.setTextColor(Color.WHITE);
	       	yes.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						popupWindow.dismiss();	
						closeApp();
					}
				});
	       	yes.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
	       			LayoutParams.WRAP_CONTENT));
	       	ll.addView(yes);
	       	
	       	Button no= new Button(getApplicationContext());
	       	no.setText("no");
	       	no.setWidth(125);
	       	no.setTextColor(Color.WHITE);
	       	no.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
	       	no.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
	       			LayoutParams.WRAP_CONTENT));
	       	ll.addView(no);
	   		
	       	popupWindow = new PopupWindow(popupView, 
			               LayoutParams.WRAP_CONTENT,  
			                     LayoutParams.WRAP_CONTENT);
	       	popupWindow.setOutsideTouchable(true);
	       	popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent));
	       	popupWindow.showAtLocation(getWindow().getDecorView(),Gravity.CENTER,0,0);
	       	
	       	menu.dismiss();
			}
		});
	    sett_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	    act_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	    voice_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
    }
	
	protected void setMask()
	{
		int ans=myApp.getCurrentExpression();
		if (ans!=-1 && mt!=null) mt.setSqueezed(8);
		switch(ans)
		{
			case 0:
				break; //la normal è già settata di default
			case 1:
				mask1.setBackgroundResource(R.drawable.basic_sadness_one);
				mask2.setBackgroundResource(R.drawable.basic_sadness_two);
				mask3.setBackgroundResource(R.drawable.basic_sadness_three);
				mask4.setBackgroundResource(R.drawable.basic_sadness_four);
				mask5.setBackgroundResource(R.drawable.basic_sadness_five);
				mask6.setBackgroundResource(R.drawable.basic_sadness_six);
				mask7.setBackgroundResource(R.drawable.basic_sadness_seven);
				maskF.setBackgroundResource(R.drawable.mask_sadness);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 2:
				mask1.setBackgroundResource(R.drawable.basic_fear_one);
				mask2.setBackgroundResource(R.drawable.basic_fear_two);
				mask3.setBackgroundResource(R.drawable.basic_fear_three);
				mask4.setBackgroundResource(R.drawable.basic_fear_four);
				mask5.setBackgroundResource(R.drawable.basic_fear_five);
				mask6.setBackgroundResource(R.drawable.basic_fear_six);
				mask7.setBackgroundResource(R.drawable.basic_fear_seven);
				maskF.setBackgroundResource(R.drawable.mask_fear);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 3:
				mask1.setBackgroundResource(R.drawable.basic_disgust_one);
				mask2.setBackgroundResource(R.drawable.basic_disgust_two);
				mask3.setBackgroundResource(R.drawable.basic_disgust_three);
				mask4.setBackgroundResource(R.drawable.basic_disgust_four);
				mask5.setBackgroundResource(R.drawable.basic_disgust_five);
				mask6.setBackgroundResource(R.drawable.basic_disgust_six);
				mask7.setBackgroundResource(R.drawable.basic_disgust_seven);
				maskF.setBackgroundResource(R.drawable.mask_disgust);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 4:
				mask1.setBackgroundResource(R.drawable.basic_surprise_one);
				mask2.setBackgroundResource(R.drawable.basic_surprise_two);
				mask3.setBackgroundResource(R.drawable.basic_surprise_three);
				mask4.setBackgroundResource(R.drawable.basic_surprise_four);
				mask5.setBackgroundResource(R.drawable.basic_surprise_five);
				mask6.setBackgroundResource(R.drawable.basic_surprise_six);
				mask7.setBackgroundResource(R.drawable.basic_surprise_seven);
				maskF.setBackgroundResource(R.drawable.mask_surprise);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 5:
				mask1.setBackgroundResource(R.drawable.basic_angry_one);
				mask2.setBackgroundResource(R.drawable.basic_angry_two);
				mask3.setBackgroundResource(R.drawable.basic_angry_three);
				mask4.setBackgroundResource(R.drawable.basic_angry_four);
				mask5.setBackgroundResource(R.drawable.basic_angry_five);
				mask6.setBackgroundResource(R.drawable.basic_angry_six);
				mask7.setBackgroundResource(R.drawable.basic_angry_seven);
				maskF.setBackgroundResource(R.drawable.mask_angry);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 6:
				mask1.setBackgroundResource(R.drawable.basic_joy_one);
				mask2.setBackgroundResource(R.drawable.basic_joy_two);
				mask3.setBackgroundResource(R.drawable.basic_joy_three);
				mask4.setBackgroundResource(R.drawable.basic_joy_four);
				mask5.setBackgroundResource(R.drawable.basic_joy_five);
				mask6.setBackgroundResource(R.drawable.basic_joy_six);
				mask7.setBackgroundResource(R.drawable.basic_joy_seven);
				maskF.setBackgroundResource(R.drawable.mask_joy);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			case 7:
				mask1.setBackgroundResource(R.drawable.basic_lowbatteries_one);
				mask2.setBackgroundResource(R.drawable.basic_lowbatteries_two);
				mask3.setBackgroundResource(R.drawable.basic_lowbatteries_three);
				mask4.setBackgroundResource(R.drawable.basic_lowbatteries_four);
				mask5.setBackgroundResource(R.drawable.basic_lowbatteries_five);
				mask6.setBackgroundResource(R.drawable.basic_lowbatteries_six);
				mask7.setBackgroundResource(R.drawable.basic_lowbatteries_seven);
				maskF.setBackgroundResource(R.drawable.mask_lowbatteries);
				mask.setVisibility(View.INVISIBLE);
				maskF.setVisibility(View.VISIBLE);
				break;
			/*case -1: //special case for squeeze
				mask1.setBackgroundResource(R.drawable.basic_squeeze_one);
				mask2.setBackgroundResource(R.drawable.basic_squeeze_two);
				mask3.setBackgroundResource(R.drawable.basic_squeeze_three);
				mask4.setBackgroundResource(R.drawable.basic_squeeze_four);
				mask5.setBackgroundResource(R.drawable.basic_squeeze_five);
				mask6.setBackgroundResource(R.drawable.basic_squeeze_six);
				mask7.setBackgroundResource(R.drawable.basic_squeeze_seven);
				maskF.setBackgroundResource(R.drawable.basic_squeeze_eight);
				switch (myApp.emp_client.getLastSqueezeSpeed())
				{
					case 1:
					{
						mask.setVisibility(View.INVISIBLE);
						mask1.setVisibility(View.VISIBLE);
						mt.setSqueezed(1);
					} break;
					case 2:
					{
						mask.setVisibility(View.INVISIBLE);
						mask2.setVisibility(View.VISIBLE);
						mt.setSqueezed(2);
					} break;
					case 3:
					{
						mask.setVisibility(View.INVISIBLE);
						mask3.setVisibility(View.VISIBLE);
						mt.setSqueezed(3);
					} break;
					case 4:
					{
						mask.setVisibility(View.INVISIBLE);
						mask4.setVisibility(View.VISIBLE);
						mt.setSqueezed(4);
					} break;
					case 5:
					{
						mask.setVisibility(View.INVISIBLE);
						mask5.setVisibility(View.VISIBLE);
						mt.setSqueezed(5);
					} break;
					case 6:
					{
						mask.setVisibility(View.INVISIBLE);
						mask6.setVisibility(View.VISIBLE);
						mt.setSqueezed(6);
					} break;
					case 7:
					{
						mask.setVisibility(View.INVISIBLE);
						mask7.setVisibility(View.VISIBLE);
						mt.setSqueezed(7);
					} break;
					case 9:
					{
						mask.setVisibility(View.INVISIBLE);
						mask9.setVisibility(View.VISIBLE);
						mt.setSqueezed(9);
					} break;
					case 10:
					{
						mask.setVisibility(View.INVISIBLE);
						mask10.setVisibility(View.VISIBLE);
						mt.setSqueezed(10);
					} break;
					default:
					{
						mask.setVisibility(View.INVISIBLE);
						maskF.setVisibility(View.VISIBLE);
						mt.setSqueezed(8);
					} break;
				}*/
			default:
				break;
		}
	}
	
	 public int switchMask(int b, int a)
	    {
	    	
			if (a==b) 
	    	{
	    		if (a!=-1)
	    			return 1;
	    		else
	    		{
	    			Log.v(TAG,"Squeeze intensity variation");
	    			return mt.specialShot(myApp.emp_client.getLastSqueezeSpeed());
	    		}
	    	}
	    	if (b==0) //se siamo in basic
	    	{
	    		//reset squueze to normal value
	    		mt.setSqueezed(8);
	    		mt.resetLoad();
	    		int delay=10;
	    		switch(a)
	    		{
	    			case 1:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_sadness_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_sadness_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_sadness_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_sadness_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_sadness_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_sadness_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_sadness_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_sadness);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 2:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_fear_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_fear_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_fear_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_fear_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_fear_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_fear_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_fear_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_fear);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 3:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_disgust_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_disgust_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_disgust_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_disgust_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_disgust_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_disgust_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_disgust_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_disgust);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 4:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_surprise_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_surprise_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_surprise_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_surprise_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_surprise_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_surprise_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_surprise_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_surprise);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 5:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_angry_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_angry_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_angry_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_angry_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_angry_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_angry_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_angry_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_angry);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 6:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_joy_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_joy_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_joy_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_joy_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_joy_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_joy_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_joy_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_joy);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			case 7:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_lowbatteries_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_lowbatteries_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_lowbatteries_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_lowbatteries_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_lowbatteries_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_lowbatteries_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_lowbatteries_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.mask_lowbatteries);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				break;
	    			/*case -1:
	    				mask1.post(new Runnable(){
							@Override
							public void run() {
								mask1.setBackgroundResource(R.drawable.basic_squeeze_one);
								mt.imageLoaded(1);
							}});
	    				mask2.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask2.setBackgroundResource(R.drawable.basic_squeeze_two);
								mt.imageLoaded(2);
							}
						}, delay);
	    				mask3.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask3.setBackgroundResource(R.drawable.basic_squeeze_three);
								mt.imageLoaded(3);
							}
						}, delay*2);
	    				mask4.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask4.setBackgroundResource(R.drawable.basic_squeeze_four);
								mt.imageLoaded(4);
							}
						}, delay*3);
	    				mask5.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask5.setBackgroundResource(R.drawable.basic_squeeze_five);
								mt.imageLoaded(5);
							}
						}, delay*4);
	    				mask6.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask6.setBackgroundResource(R.drawable.basic_squeeze_six);
								mt.imageLoaded(6);
							}
						}, delay*5);
	    				mask7.postDelayed(new Runnable() {
							@Override
							public void run() {
								mask7.setBackgroundResource(R.drawable.basic_squeeze_seven);
								mt.imageLoaded(7);
							}
						}, delay*6);
	    				maskF.postDelayed(new Runnable() {
							@Override
							public void run() {
								maskF.setBackgroundResource(R.drawable.basic_squeeze_eight);
								mt.imageLoaded(8);
							}
						}, delay*7);
	    				mt.setSqueezed(myApp.emp_client.getLastSqueezeSpeed());
	    				break;*/
	    			default: break;
	    		}
	    		return mt.shot2(false,a);
	    	}
	    	else //altrimenti
	    	{
	    		return mt.shot2(true,a);
	    	}
	    }
	
	public void changeAction()
	{
		runningAction.setText(myApp.getCurrentTask());
	}
	
	protected final int SETTINGS_CODE=10;
	
	//Method to manage the callback from a start activity for results (i.e. it runs when you change the settings)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	try{
    		super.onActivityResult(requestCode, resultCode, data);
    	}catch(Exception e){
    		Log.i(TAG,"Exception on Activity resut");
    		myApp.unsetSettings();
    	}
    	switch(requestCode){
        	case(SETTINGS_CODE):{
        		if(resultCode==Activity.RESULT_OK)
        		{
        			myApp.unsetSettings();
        			myPreferences.loadPreferences();
        			myApp.updatePreferences();
        			//myApp.restartServices(myPreferences);
        			Log.i("AccompanyGUI","onActivityResult");
        		}
        	} break;
    	}
    }

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// do nothing x ora
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		myThread=new DrawingThread(holder);
		myThread.start();
		myApp.setDrawingThread(myThread);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		myThread.stopDraw();
		try {
			myThread.join();
		} catch (InterruptedException e) {
			Log.e(TAG, "Thread stop problem!");
		}
	}
	
	@Override
	public void onPause()
	{
		if (myThread!=null) myThread.pause();
		checkClosure();
		super.onPause();
		Log.i(TAG,"on pause");
	}
	
	public void closeApp()
	{
		if (pdd!=null) pdd.dismiss();
		pdd= ProgressDialog.show(RobotWorkingView.this, RobotWorkingView.this.getResources().getString(R.string.gui_title),
				"Closing application. Please wait...");
		pdd.setCancelable(false);
		animationHandler.postDelayed(new Runnable(){
			@Override
			public void run() {
				myApp.closeApp();
			}}, 250);
	}
	
	public void checkClosure()
	{
		if (toClose)
		{
			Log.w(TAG,"Closing app...");
			Log.v(TAG,"Received pause request from something external to the app.");
			closeApp();//myApp.closeApp();
		}
	}
}
