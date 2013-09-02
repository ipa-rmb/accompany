package it.unisi.accompany.threads;

import it.unisi.accompany.activities.RobotWorkingView;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class MaskAnimationThreadWorking extends Thread{

	protected final String TAG = "AccompanyGUI-MaskAnimationThread(W)";
	
	Handler hh;
	RobotWorkingView act;
	boolean sshot=false;
	boolean v;
	boolean interrupt=false;
	boolean pause=false;
	int after;
	
	protected int squeezed=8;
	
	boolean im1,im2,im3,im4,im5,im6,im7,imF;
	
	public MaskAnimationThreadWorking(Handler h,RobotWorkingView ma)
	{
		hh=h;
		act=ma;
		squeezed=8;
	}
	
	public void setSqueezed(int ss)
	{
		squeezed=ss;
	}
	
	@Override
	public void run()
	{
		im1=true;
		im2=true;
		im3=true;
		im4=true;
		im5=true;
		im6=true;
		im7=true;
		imF=true;
		while (!interrupt)
		{
			squeezed=8;     //togliere quando si rimette espressione squeeze!
			while (!sshot&&!interrupt)
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Log.e("sleep","interrupted!");
					interrupt=true;
				}
			}
			//wait to have all the images loaded
			while ((!im1||!im2||!im3||!im4||!im5||!im6||!im7||!imF) && !interrupt)
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Log.e("sleep","interrupted!");
					interrupt=true;
				}
			}
			if (!interrupt&&!pause)
			{
				if (v)
				{
					/*if (squeezed>9)
					{
						hh.post(new Runnable() {
						
							@Override
							public void run() {
								act.mask10.setVisibility(View.INVISIBLE);
								act.mask9.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>8)
					{
						hh.post(new Runnable() {
						
							@Override
							public void run() {
								act.mask9.setVisibility(View.INVISIBLE);
								act.maskF.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}*/
					if (squeezed>7)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.maskF.setVisibility(View.INVISIBLE);
								act.mask7.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>6)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask7.setVisibility(View.INVISIBLE);
								act.mask6.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>5)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask6.setVisibility(View.INVISIBLE);
								act.mask5.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>4)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask5.setVisibility(View.INVISIBLE);
								act.mask4.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>3)
					{
						hh.post(new Runnable() {
						
							
							@Override
							public void run() {
								act.mask4.setVisibility(View.INVISIBLE);
								act.mask3.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>2)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask3.setVisibility(View.INVISIBLE);
								act.mask2.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					if (squeezed>1)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask2.setVisibility(View.INVISIBLE);
								act.mask1.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","interrupted!");
							interrupt=true;
						}
					}
					
					resetLoad();
					
					sshot=false;
					hh.post(new Runnable() {
						
						@Override
						public void run() {
							act.mask1.setVisibility(View.INVISIBLE);
							act.mask.setVisibility(View.VISIBLE);
							if (after!=0)
							{
								act.switchMask(0, after);
							}
						}
					});
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						Log.e("sleep","interrupted!");
						interrupt=true;
					}
										
				}
				else
				{
					hh.post(new Runnable() {
						
						@Override
						public void run() {
							act.mask.setVisibility(View.INVISIBLE);
							act.mask1.setVisibility(View.VISIBLE);
						}
					});
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						Log.e("sleep","sleep");
					}
					if (squeezed>1)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask1.setVisibility(View.INVISIBLE);
								act.mask2.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>2)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask2.setVisibility(View.INVISIBLE);
								act.mask3.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>3)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask3.setVisibility(View.INVISIBLE);
								act.mask4.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>4)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask4.setVisibility(View.INVISIBLE);
								act.mask5.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>5)
					{
						hh.post(new Runnable() {
											
							@Override
							public void run() {
								act.mask5.setVisibility(View.INVISIBLE);
								act.mask6.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if(squeezed>6)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask6.setVisibility(View.INVISIBLE);
								act.mask7.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>7)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask7.setVisibility(View.INVISIBLE);
								act.maskF.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					/*if (squeezed>8)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.maskF.setVisibility(View.INVISIBLE);
								act.mask9.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}
					if (squeezed>9)
					{
						hh.post(new Runnable() {
							
							@Override
							public void run() {
								act.mask9.setVisibility(View.INVISIBLE);
								act.mask10.setVisibility(View.VISIBLE);
							}
						});
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							Log.e("sleep","sleep");
						}
					}*/
					sshot=false;
				}
			}
		}
	}
	
	public void resetLoad()
	{
		im1=false;
		im2=false;
		im3=false;
		im4=false;
		im5=false;
		im6=false;
		im7=false;
		imF=false;
	}
	
	public void imageLoaded(int idx)
	{
		switch (idx)
		{
			case 1:
				im1=true;
				break;
			case 2:
				im2=true;
				break;
			case 3:
				im3= true;
				break;
			case 4:
				im4= true;
				break;
			case 5:
				im5= true;
				break;
			case 6:
				im6= true;
				break;
			case 7:
				im7= true;
				break;
			case 8:
				imF= true;
				break;
			default:
				break;
		}
	}
	
	public void terminate()
	{
		interrupt=true;
	}
	
	public void shot(boolean verso)
	{
		sshot=true;
		v=verso;
	}
	
	public void pause()
	{
		pause=true;
	}
	
	public void continueRun()
	{
		pause=false;
	}
	
	public int shot2(boolean verso,int a)
	{
		if (sshot==false)
		{
			after=a;
			sshot=true;
			v=verso;
			return 1;
		}
		else
			return 0;
	}
	
	public int specialShot(int newspeed)
	{
		/*Log.v(TAG,"Special shot... Squuezed value ->"+squeezed+". New value ->"+ newspeed);
		if (sshot) return 0;
		if (newspeed==squeezed) return 1;
		else
		{
			Log.i(TAG,"Special shot running! ("+squeezed+" -> "+newspeed+")");
			if (squeezed<newspeed)
			{	
				int delay=0;
				int step=50;
				if (squeezed==1)
				{
					hh.post(new Runnable() {
						
						@Override
						public void run() {
							act.mask1.setVisibility(View.INVISIBLE);
							act.mask2.setVisibility(View.VISIBLE);
						}
					});
					delay+=step;
				}
				if (squeezed<3 && newspeed>2)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask2.setVisibility(View.INVISIBLE);
							act.mask3.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<4 && newspeed>3)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask3.setVisibility(View.INVISIBLE);
							act.mask4.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<5 && newspeed>4)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask4.setVisibility(View.INVISIBLE);
							act.mask5.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<6 && newspeed>5)
				{
					hh.postDelayed(new Runnable() {
										
						@Override
						public void run() {
							act.mask5.setVisibility(View.INVISIBLE);
							act.mask6.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if(squeezed<7 && newspeed>6)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask6.setVisibility(View.INVISIBLE);
							act.mask7.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<8 && newspeed>7)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask7.setVisibility(View.INVISIBLE);
							act.maskF.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<9 && newspeed>8)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.maskF.setVisibility(View.INVISIBLE);
							act.mask9.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed<10 && newspeed>9)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask9.setVisibility(View.INVISIBLE);
							act.mask10.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
			}
			else
			{
				int delay=0;
				int step=50;
				if (squeezed==10)
				{
					hh.post(new Runnable() {
						
						@Override
						public void run() {
							act.mask10.setVisibility(View.INVISIBLE);
							act.mask9.setVisibility(View.VISIBLE);
						}
					});
					delay+=step;
				}
				if (squeezed>8 && newspeed<9)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask9.setVisibility(View.INVISIBLE);
							act.maskF.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>7 && newspeed<8)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.maskF.setVisibility(View.INVISIBLE);
							act.mask7.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>6 && newspeed<7)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask7.setVisibility(View.INVISIBLE);
							act.mask6.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>5 && newspeed<6)
				{
					hh.postDelayed(new Runnable() {
										
						@Override
						public void run() {
							act.mask6.setVisibility(View.INVISIBLE);
							act.mask5.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if(squeezed>4 && newspeed<5)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask5.setVisibility(View.INVISIBLE);
							act.mask4.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>3 && newspeed<4)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask4.setVisibility(View.INVISIBLE);
							act.mask3.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>2 && newspeed<3)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask3.setVisibility(View.INVISIBLE);
							act.mask2.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
				if (squeezed>1 && newspeed==1)
				{
					hh.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							act.mask2.setVisibility(View.INVISIBLE);
							act.mask1.setVisibility(View.VISIBLE);
						}
					},delay);
					delay+=step;
				}
			}
		}
		squeezed=newspeed;
		return 1;*/
		return 1;   //rimettere sopra e togli questo quando si rimette squeeze
	}
}
