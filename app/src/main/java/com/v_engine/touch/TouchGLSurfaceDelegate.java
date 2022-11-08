package com.v_engine.touch;

import android.graphics.PointF;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import com.v_engine.gl_surface.EngineGLSurfaceView;

public class TouchGLSurfaceDelegate  {

    private final static String TOUCH_START = "ontouchstart";
    private final static String TOUCH_MOVE  = "ontouchmove";
    private final static String TOUCH_END   = "ontouchend";

    private SparseArray<PointF> mActivePointers = new SparseArray<>();
    private EngineGLSurfaceView glSurfaceView;

    public TouchGLSurfaceDelegate(EngineGLSurfaceView glSurfaceView) {
        this.glSurfaceView = glSurfaceView;
    }

    private void dispatchEvent(float x, float y, int pointerID, String actionName) {
        glSurfaceView.dispatchEvent(x, y, pointerID, actionName);
    }


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
                dispatchEvent(f.x,f.y, pointerId, TOUCH_START);
                break;
            }
            case MotionEvent.ACTION_MOVE: { // a pointer was moved
                for (int size = e.getPointerCount(), i = 0; i < size; i++) {
                    int id = e.getPointerId(i);
                    PointF point = mActivePointers.get(e.getPointerId(i));
                    if (point != null) {
                        point.x = e.getX(i);
                        point.y = e.getY(i);
                        dispatchEvent(point.x, point.y, id, TOUCH_MOVE);
                    }
                }
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL: {
                mActivePointers.remove(pointerId);
                dispatchEvent(e.getX(pointerIndex), e.getY(pointerIndex), pointerId, TOUCH_END);
                break;
            }
        }
        return true;
    }
}
