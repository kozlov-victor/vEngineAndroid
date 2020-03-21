package com.example.v_engine.misc.buffers;

import android.util.SparseArray;


import com.eclipsesource.v8.V8TypedArray;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class Buffers {

    private SparseArray<BufferHolder<FloatBuffer>> floatBufferCache = new SparseArray<>();
    private SparseArray<BufferHolder<IntBuffer>>   intBufferCache   = new SparseArray<>();
    private SparseArray<BufferHolder<ShortBuffer>>   shortBufferCache   = new SparseArray<>();
    private SparseArray<ByteBuffer>  byteBufferCache  = new SparseArray<>();

    public FloatBuffer toFloatBuffer(V8TypedArray array){
        int size = array.length();
        BufferHolder<FloatBuffer> possibleBufferHolder = floatBufferCache.get(size);
        if (possibleBufferHolder==null) {
            ByteBuffer bb = ByteBuffer.allocateDirect(size*4);
            bb.order(ByteOrder.nativeOrder());
            FloatBuffer b = bb.asFloatBuffer();
            possibleBufferHolder = new BufferHolder<>(bb,b);
            floatBufferCache.put(size,possibleBufferHolder);
        }
        possibleBufferHolder.rewind();
        for (int i = 0; i < size; i++) {
            possibleBufferHolder.getBuffer().put(i,(float) array.getDouble(i));
        }
        possibleBufferHolder.rewind();
        return possibleBufferHolder.getBuffer();
    }

    public IntBuffer toIntBuffer(V8TypedArray array){
        int size = array.length();
        BufferHolder<IntBuffer> possibleBufferHolder = intBufferCache.get(size);
        if (possibleBufferHolder==null) {
            ByteBuffer bb = ByteBuffer.allocateDirect(size*4);
            bb.order(ByteOrder.nativeOrder());
            IntBuffer b = bb.asIntBuffer();
            possibleBufferHolder = new BufferHolder<>(bb,b);
            intBufferCache.put(size,possibleBufferHolder);
        }
        possibleBufferHolder.rewind();
        for (int i = 0; i < size; i++) {
            possibleBufferHolder.getBuffer().put(i,array.getInteger(i));
        }
        possibleBufferHolder.rewind();
        return possibleBufferHolder.getBuffer();
    }

    public ShortBuffer toShortBuffer(V8TypedArray array){
        int size = array.length();
        BufferHolder<ShortBuffer> possibleBuffer = shortBufferCache.get(size);
        if (possibleBuffer==null) {
            ByteBuffer bb = ByteBuffer.allocateDirect(size*4);
            bb.order(ByteOrder.nativeOrder());
            ShortBuffer b = bb.asShortBuffer();
            possibleBuffer = new BufferHolder<>(bb,b);
            shortBufferCache.put(size,possibleBuffer);
        }
        possibleBuffer.rewind();
        for (int i = 0; i < size; i++) {
            possibleBuffer.getBuffer().put(i,(short) array.getInteger(i));
        }
        possibleBuffer.rewind();
        return possibleBuffer.getBuffer();
    }

    public ByteBuffer toByteBuffer(V8TypedArray array){
        int size = array.length();
        ByteBuffer possibleBuffer = byteBufferCache.get(size);
        if (possibleBuffer==null) {
            ByteBuffer bb = ByteBuffer.allocateDirect(size);
            bb.order(ByteOrder.nativeOrder());
            bb.position(0);
            possibleBuffer = bb;
            byteBufferCache.put(size,possibleBuffer);
        }
        possibleBuffer.position(0);
        for (int i = 0; i < size; i++) {
            possibleBuffer.put(i,array.getByte(i));
        }
        possibleBuffer.position(0);
        return possibleBuffer;
    }

}
