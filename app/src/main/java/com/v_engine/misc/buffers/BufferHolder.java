package com.v_engine.misc.buffers;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferHolder<T extends Buffer> {

    private ByteBuffer byteBuffer;
    private T buffer;

    public BufferHolder(ByteBuffer byteBuffer, T buffer) {
        this.byteBuffer = byteBuffer;
        this.buffer = buffer;
        this.byteBuffer.mark();
    }

    public T getBuffer() {
        return buffer;
    }

    public void rewind(){
        buffer.position(0);
        byteBuffer.position(0);
    }


}


