package com.v_engine.touch;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

public abstract class TouchGLSurface extends GLSurfaceView implements View.OnTouchListener  {

    private SparseArray<PointF> mActivePointers = new SparseArray<>();

    protected abstract void dispatchEvent(float x, float y, int pointerID, String actionName);

    public TouchGLSurface(Context context) {
        super(context);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {

        int pointerIndex = e.getActionIndex();
        int pointerId = e.getPointerId(pointerIndex);
        int maskedAction = e.getActionMasked(); //  (not specific to a pointer) action

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                PointF f = new PointF();
                f.x = e.getX(pointerIndex);
                f.y = e.getY(pointerIndex);
                mActivePointers.put(pointerId, f);
                dispatchEvent(f.x,f.y, pointerId,"ontouchstart");
                break;
            }
            case MotionEvent.ACTION_MOVE: { // a pointer was moved
                for (int size = e.getPointerCount(), i = 0; i < size; i++) {
                    int id = e.getPointerId(i);
                    PointF point = mActivePointers.get(e.getPointerId(i));
                    if (point != null) {
                        point.x = e.getX(i);
                        point.y = e.getY(i);
                        dispatchEvent(point.x, point.y, id,"ontouchmove");
                    }
                }
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL: {
                mActivePointers.remove(pointerId);
                dispatchEvent(e.getX(pointerIndex), e.getX(pointerIndex), pointerId,"ontouchend");
                break;
            }
        }
        return true;
    }
}
