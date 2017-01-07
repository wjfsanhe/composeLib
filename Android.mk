LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)

LOCAL_MODULE := SurfaceComposerLib

LOCAL_SRC_FILES := $(call all-java-files-under, lib_src)

include $(BUILD_STATIC_JAVA_LIBRARY)

include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-java-files-under, apk_src)
LOCAL_MODULE := TestSurfaceCompose
LOCAL_STATIC_JAVA_LIBRARIES = SurfaceComposerLib
include $(BUILD_JAVA_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=tscl
LOCAL_SRC_FILES := tscl
LOCAL_MODULE_CLASS := EXECUTABLES
LOCAL_MODULE_TAGS := optional
include $(BUILD_PREBUILT)


