//author: wangjf
package com.baofeng.surfacecomposerlib;

import android.os.IBinder;
import android.os.ServiceManager;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public final class  SurfaceComposerMessenger{
    private static final String TAG = "SurfaceComposerMessenger";
    private static final int DATA_MSG =0;
    private static final int DATA_BYTE =1;
    private static final byte[] extraData = {0x00,0x00,0x00,0x00};
    private static SurfaceComposerMessenger mMessenger;
    public MessageBody mMessageBody;
    public static class MessageBody{
        //Quaternion data.
        public float x;
        public float y;
        public float z;
        public float w;
        //key data
        public int keyCode;
    }
    private SurfaceComposerMessenger() {
    }

    public static SurfaceComposerMessenger getInstance() {
        synchronized (SurfaceComposerMessenger.class) {
            if (mMessenger == null) {
                mMessenger = new SurfaceComposerMessenger();
            }
            return mMessenger;
        }
    }
    public void sendMessage(MessageBody message){
    try{
        IBinder flinger = ServiceManager.getService("SurfaceFlinger");
        if (flinger != null) {
                Parcel data = Parcel.obtain();
                data.writeInterfaceToken("android.ui.ISurfaceComposer");
                data.writeInt(DATA_MSG);
                data.writeFloat(message.x);
                data.writeFloat(message.y);
                data.writeFloat(message.z);
                data.writeFloat(message.w);
                data.writeInt(message.keyCode);
                flinger.transact(8888, data, null, 0);
                Log.d(TAG,"data sended: keycode[ "+message.keyCode+" ]");
                data.recycle();
            }
        } catch (RemoteException ex) {
        }
    }
    public void sendMessage(byte[] message){
    try{
        IBinder flinger = ServiceManager.getService("SurfaceFlinger");
        if (flinger != null) {
                Parcel data = Parcel.obtain();
                data.writeInterfaceToken("android.ui.ISurfaceComposer");
                data.writeInt(DATA_BYTE);
                data.writeByteArray(message);
                flinger.transact(8888, data, null, 0);
                Log.d(TAG,"data sended: byte array len : ["+message.length+"]" + ",message[0]=" +message[0]);
                data.recycle();
            }
        } catch (RemoteException ex) {
        }
    }

}
