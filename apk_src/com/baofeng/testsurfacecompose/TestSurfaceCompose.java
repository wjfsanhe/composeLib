package com.baofeng.testsurfacecompose ;

import com.baofeng.surfacecomposerlib.SurfaceComposerMessenger;

public final class TestSurfaceCompose {
static final String TAG = "TestSurfaceCompose" ;
public static void main(String[] args) {
        SurfaceComposerMessenger  mMessenger=SurfaceComposerMessenger.getInstance();
        System.out.println(TAG+": Start send message");
        //type 1
        mMessenger.mMessageBody= new SurfaceComposerMessenger.MessageBody() ;
        mMessenger.mMessageBody.keyCode=0x16;
        mMessenger.sendMessage(mMessenger.mMessageBody);
        //type 2
        byte[] message = new byte[20] ;
        for (char i=0;i<20;i++){
            message[i]= (byte)(i+1) ;
        }
        mMessenger.sendMessage(message);
      }
}
