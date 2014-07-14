# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 2.8

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/accompany/git/accompany/accompany_static_camera_localisation

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/accompany/git/accompany/accompany_static_camera_localisation/build

# Include any dependencies generated for this target.
include CMakeFiles/staticCam.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/staticCam.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/staticCam.dir/flags.make

CMakeFiles/staticCam.dir/src/Helpers.cc.o: CMakeFiles/staticCam.dir/flags.make
CMakeFiles/staticCam.dir/src/Helpers.cc.o: ../src/Helpers.cc
	$(CMAKE_COMMAND) -E cmake_progress_report /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object CMakeFiles/staticCam.dir/src/Helpers.cc.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -o CMakeFiles/staticCam.dir/src/Helpers.cc.o -c /home/accompany/git/accompany/accompany_static_camera_localisation/src/Helpers.cc

CMakeFiles/staticCam.dir/src/Helpers.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/staticCam.dir/src/Helpers.cc.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -E /home/accompany/git/accompany/accompany_static_camera_localisation/src/Helpers.cc > CMakeFiles/staticCam.dir/src/Helpers.cc.i

CMakeFiles/staticCam.dir/src/Helpers.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/staticCam.dir/src/Helpers.cc.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -S /home/accompany/git/accompany/accompany_static_camera_localisation/src/Helpers.cc -o CMakeFiles/staticCam.dir/src/Helpers.cc.s

CMakeFiles/staticCam.dir/src/Helpers.cc.o.requires:
.PHONY : CMakeFiles/staticCam.dir/src/Helpers.cc.o.requires

CMakeFiles/staticCam.dir/src/Helpers.cc.o.provides: CMakeFiles/staticCam.dir/src/Helpers.cc.o.requires
	$(MAKE) -f CMakeFiles/staticCam.dir/build.make CMakeFiles/staticCam.dir/src/Helpers.cc.o.provides.build
.PHONY : CMakeFiles/staticCam.dir/src/Helpers.cc.o.provides

CMakeFiles/staticCam.dir/src/Helpers.cc.o.provides.build: CMakeFiles/staticCam.dir/src/Helpers.cc.o

CMakeFiles/staticCam.dir/src/Background.cc.o: CMakeFiles/staticCam.dir/flags.make
CMakeFiles/staticCam.dir/src/Background.cc.o: ../src/Background.cc
	$(CMAKE_COMMAND) -E cmake_progress_report /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles $(CMAKE_PROGRESS_2)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object CMakeFiles/staticCam.dir/src/Background.cc.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -o CMakeFiles/staticCam.dir/src/Background.cc.o -c /home/accompany/git/accompany/accompany_static_camera_localisation/src/Background.cc

CMakeFiles/staticCam.dir/src/Background.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/staticCam.dir/src/Background.cc.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -E /home/accompany/git/accompany/accompany_static_camera_localisation/src/Background.cc > CMakeFiles/staticCam.dir/src/Background.cc.i

CMakeFiles/staticCam.dir/src/Background.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/staticCam.dir/src/Background.cc.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -S /home/accompany/git/accompany/accompany_static_camera_localisation/src/Background.cc -o CMakeFiles/staticCam.dir/src/Background.cc.s

CMakeFiles/staticCam.dir/src/Background.cc.o.requires:
.PHONY : CMakeFiles/staticCam.dir/src/Background.cc.o.requires

CMakeFiles/staticCam.dir/src/Background.cc.o.provides: CMakeFiles/staticCam.dir/src/Background.cc.o.requires
	$(MAKE) -f CMakeFiles/staticCam.dir/build.make CMakeFiles/staticCam.dir/src/Background.cc.o.provides.build
.PHONY : CMakeFiles/staticCam.dir/src/Background.cc.o.provides

CMakeFiles/staticCam.dir/src/Background.cc.o.provides.build: CMakeFiles/staticCam.dir/src/Background.cc.o

CMakeFiles/staticCam.dir/src/ImgProducer.cc.o: CMakeFiles/staticCam.dir/flags.make
CMakeFiles/staticCam.dir/src/ImgProducer.cc.o: ../src/ImgProducer.cc
	$(CMAKE_COMMAND) -E cmake_progress_report /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles $(CMAKE_PROGRESS_3)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object CMakeFiles/staticCam.dir/src/ImgProducer.cc.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -o CMakeFiles/staticCam.dir/src/ImgProducer.cc.o -c /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImgProducer.cc

CMakeFiles/staticCam.dir/src/ImgProducer.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/staticCam.dir/src/ImgProducer.cc.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -E /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImgProducer.cc > CMakeFiles/staticCam.dir/src/ImgProducer.cc.i

CMakeFiles/staticCam.dir/src/ImgProducer.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/staticCam.dir/src/ImgProducer.cc.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -S /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImgProducer.cc -o CMakeFiles/staticCam.dir/src/ImgProducer.cc.s

CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.requires:
.PHONY : CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.requires

CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.provides: CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.requires
	$(MAKE) -f CMakeFiles/staticCam.dir/build.make CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.provides.build
.PHONY : CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.provides

CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.provides.build: CMakeFiles/staticCam.dir/src/ImgProducer.cc.o

CMakeFiles/staticCam.dir/src/CamCalib.cc.o: CMakeFiles/staticCam.dir/flags.make
CMakeFiles/staticCam.dir/src/CamCalib.cc.o: ../src/CamCalib.cc
	$(CMAKE_COMMAND) -E cmake_progress_report /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles $(CMAKE_PROGRESS_4)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object CMakeFiles/staticCam.dir/src/CamCalib.cc.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -o CMakeFiles/staticCam.dir/src/CamCalib.cc.o -c /home/accompany/git/accompany/accompany_static_camera_localisation/src/CamCalib.cc

CMakeFiles/staticCam.dir/src/CamCalib.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/staticCam.dir/src/CamCalib.cc.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -E /home/accompany/git/accompany/accompany_static_camera_localisation/src/CamCalib.cc > CMakeFiles/staticCam.dir/src/CamCalib.cc.i

CMakeFiles/staticCam.dir/src/CamCalib.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/staticCam.dir/src/CamCalib.cc.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -S /home/accompany/git/accompany/accompany_static_camera_localisation/src/CamCalib.cc -o CMakeFiles/staticCam.dir/src/CamCalib.cc.s

CMakeFiles/staticCam.dir/src/CamCalib.cc.o.requires:
.PHONY : CMakeFiles/staticCam.dir/src/CamCalib.cc.o.requires

CMakeFiles/staticCam.dir/src/CamCalib.cc.o.provides: CMakeFiles/staticCam.dir/src/CamCalib.cc.o.requires
	$(MAKE) -f CMakeFiles/staticCam.dir/build.make CMakeFiles/staticCam.dir/src/CamCalib.cc.o.provides.build
.PHONY : CMakeFiles/staticCam.dir/src/CamCalib.cc.o.provides

CMakeFiles/staticCam.dir/src/CamCalib.cc.o.provides.build: CMakeFiles/staticCam.dir/src/CamCalib.cc.o

CMakeFiles/staticCam.dir/src/ImageMask.cpp.o: CMakeFiles/staticCam.dir/flags.make
CMakeFiles/staticCam.dir/src/ImageMask.cpp.o: ../src/ImageMask.cpp
	$(CMAKE_COMMAND) -E cmake_progress_report /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles $(CMAKE_PROGRESS_5)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object CMakeFiles/staticCam.dir/src/ImageMask.cpp.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -o CMakeFiles/staticCam.dir/src/ImageMask.cpp.o -c /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImageMask.cpp

CMakeFiles/staticCam.dir/src/ImageMask.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/staticCam.dir/src/ImageMask.cpp.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -E /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImageMask.cpp > CMakeFiles/staticCam.dir/src/ImageMask.cpp.i

CMakeFiles/staticCam.dir/src/ImageMask.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/staticCam.dir/src/ImageMask.cpp.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -W -Wall -Wno-unused-parameter -fno-strict-aliasing -pthread -S /home/accompany/git/accompany/accompany_static_camera_localisation/src/ImageMask.cpp -o CMakeFiles/staticCam.dir/src/ImageMask.cpp.s

CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.requires:
.PHONY : CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.requires

CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.provides: CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.requires
	$(MAKE) -f CMakeFiles/staticCam.dir/build.make CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.provides.build
.PHONY : CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.provides

CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.provides.build: CMakeFiles/staticCam.dir/src/ImageMask.cpp.o

# Object files for target staticCam
staticCam_OBJECTS = \
"CMakeFiles/staticCam.dir/src/Helpers.cc.o" \
"CMakeFiles/staticCam.dir/src/Background.cc.o" \
"CMakeFiles/staticCam.dir/src/ImgProducer.cc.o" \
"CMakeFiles/staticCam.dir/src/CamCalib.cc.o" \
"CMakeFiles/staticCam.dir/src/ImageMask.cpp.o"

# External object files for target staticCam
staticCam_EXTERNAL_OBJECTS =

../lib/libstaticCam.so: CMakeFiles/staticCam.dir/src/Helpers.cc.o
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/src/Background.cc.o
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/src/ImgProducer.cc.o
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/src/CamCalib.cc.o
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/src/ImageMask.cpp.o
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/build.make
../lib/libstaticCam.so: CMakeFiles/staticCam.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --red --bold "Linking CXX shared library ../lib/libstaticCam.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/staticCam.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/staticCam.dir/build: ../lib/libstaticCam.so
.PHONY : CMakeFiles/staticCam.dir/build

CMakeFiles/staticCam.dir/requires: CMakeFiles/staticCam.dir/src/Helpers.cc.o.requires
CMakeFiles/staticCam.dir/requires: CMakeFiles/staticCam.dir/src/Background.cc.o.requires
CMakeFiles/staticCam.dir/requires: CMakeFiles/staticCam.dir/src/ImgProducer.cc.o.requires
CMakeFiles/staticCam.dir/requires: CMakeFiles/staticCam.dir/src/CamCalib.cc.o.requires
CMakeFiles/staticCam.dir/requires: CMakeFiles/staticCam.dir/src/ImageMask.cpp.o.requires
.PHONY : CMakeFiles/staticCam.dir/requires

CMakeFiles/staticCam.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/staticCam.dir/cmake_clean.cmake
.PHONY : CMakeFiles/staticCam.dir/clean

CMakeFiles/staticCam.dir/depend:
	cd /home/accompany/git/accompany/accompany_static_camera_localisation/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/accompany/git/accompany/accompany_static_camera_localisation /home/accompany/git/accompany/accompany_static_camera_localisation /home/accompany/git/accompany/accompany_static_camera_localisation/build /home/accompany/git/accompany/accompany_static_camera_localisation/build /home/accompany/git/accompany/accompany_static_camera_localisation/build/CMakeFiles/staticCam.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/staticCam.dir/depend

