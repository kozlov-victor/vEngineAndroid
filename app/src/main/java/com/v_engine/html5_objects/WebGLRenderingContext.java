package com.v_engine.html5_objects;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import com.v_engine.resource_manager.FilesResourceManager;
import com.v_engine.misc.GLObjects;

import java.nio.IntBuffer;

public class WebGLRenderingContext {

    public final int UNPACK_PREMULTIPLY_ALPHA_WEBGL = -1;
    public final int UNPACK_FLIP_Y_WEBGL = -1;
    public final int STATIC_DRAW = GLES20.GL_STATIC_DRAW;
    public final int DYNAMIC_DRAW = GLES20.GL_DYNAMIC_DRAW;

    public final int ACTIVE_TEXTURE = GLES20.GL_ACTIVE_TEXTURE;
    public final int DEPTH_BUFFER_BIT = GLES20.GL_DEPTH_BUFFER_BIT;
    public final int STENCIL_BUFFER_BIT = GLES20.GL_STENCIL_BUFFER_BIT;
    public final int COLOR_BUFFER_BIT = GLES20.GL_COLOR_BUFFER_BIT;
    public final int FALSE = GLES20.GL_FALSE;
    public final int TRUE = GLES20.GL_TRUE;
    public final int POINTS = GLES20.GL_POINTS;
    public final int LINES = GLES20.GL_LINES;
    public final int LINE_LOOP = GLES20.GL_LINE_LOOP;
    public final int LINE_STRIP =GLES20.GL_LINE_STRIP;
    public final int TRIANGLES = GLES20.GL_TRIANGLES;
    public final int TRIANGLE_STRIP = GLES20.GL_TRIANGLE_STRIP;
    public final int TRIANGLE_FAN = GLES20.GL_TRIANGLE_FAN;
    public final int ZERO = GLES20.GL_ZERO;
    public final int ONE =GLES20.GL_ONE;
    public final int SRC_COLOR = GLES20.GL_SRC_COLOR;
    public final int ONE_MINUS_SRC_COLOR = GLES20.GL_ONE_MINUS_SRC_COLOR;
    public final int SRC_ALPHA = GLES20.GL_SRC_ALPHA;
    public final int ONE_MINUS_SRC_ALPHA = GLES20.GL_ONE_MINUS_SRC_ALPHA;
    public final int DST_ALPHA = GLES20.GL_DST_ALPHA;
    public final int ONE_MINUS_DST_ALPHA = GLES20.GL_ONE_MINUS_DST_ALPHA;
    public final int DST_COLOR = GLES20.GL_DST_COLOR;
    public final int ONE_MINUS_DST_COLOR =GLES20.GL_ONE_MINUS_DST_COLOR;
    public final int SRC_ALPHA_SATURATE = GLES20.GL_SRC_ALPHA_SATURATE;
    public final int FUNC_ADD = GLES20.GL_FUNC_ADD;
    public final int BLEND_EQUATION = GLES20.GL_BLEND_EQUATION;
    public final int BLEND_EQUATION_RGB = GLES20.GL_BLEND_EQUATION_RGB;
    public final int BLEND_EQUATION_ALPHA = GLES20.GL_BLEND_EQUATION_ALPHA;
    public final int FUNC_SUBTRACT = GLES20.GL_FUNC_SUBTRACT;
    public final int FUNC_REVERSE_SUBTRACT = GLES20.GL_FUNC_REVERSE_SUBTRACT;
    public final int BLEND_DST_RGB = GLES20.GL_BLEND_DST_RGB;
    public final int BLEND_SRC_RGB = GLES20.GL_BLEND_SRC_RGB;
    public final int BLEND_DST_ALPHA = GLES20.GL_BLEND_DST_ALPHA;
    public final int BLEND_SRC_ALPHA = GLES20.GL_BLEND_SRC_ALPHA;
    public final int CONSTANT_COLOR = GLES20.GL_CONSTANT_COLOR;
    public final int ONE_MINUS_CONSTANT_COLOR = GLES20.GL_ONE_MINUS_CONSTANT_COLOR;
    public final int CONSTANT_ALPHA = GLES20.GL_CONSTANT_ALPHA;
    public final int ONE_MINUS_CONSTANT_ALPHA = GLES20.GL_ONE_MINUS_CONSTANT_ALPHA;

    public final int BLEND_COLOR = GLES20.GL_BLEND_COLOR;
    public final int ARRAY_BUFFER = GLES20.GL_ARRAY_BUFFER;
    public final int ELEMENT_ARRAY_BUFFER = GLES20.GL_ELEMENT_ARRAY_BUFFER;
    public final int ARRAY_BUFFER_BINDING = GLES20.GL_ARRAY_BUFFER_BINDING;
    public final int ELEMENT_ARRAY_BUFFER_BINDING = GLES20.GL_ELEMENT_ARRAY_BUFFER_BINDING;
    public final int STREAM_DRAW = GLES20.GL_STREAM_DRAW;
    public final int BUFFER_SIZE = GLES20.GL_BUFFER_SIZE;
    public final int BUFFER_USAGE = GLES20.GL_BUFFER_USAGE;
    public final int CURRENT_VERTEX_ATTRIB = GLES20.GL_CURRENT_VERTEX_ATTRIB;
    public final int FRONT = GLES20.GL_FRONT;
    public final int BACK = GLES20.GL_BACK;
    public final int FRONT_AND_BACK = GLES20.GL_FRONT_AND_BACK;
    public final int TEXTURE_2D = GLES20.GL_TEXTURE_2D;
    public final int CULL_FACE = GLES20.GL_CULL_FACE;
    public final int BLEND = GLES20.GL_BLEND;
    public final int DITHER = GLES20.GL_DITHER;
    public final int STENCIL_TEST = GLES20.GL_STENCIL_TEST;
    public final int DEPTH_TEST = GLES20.GL_DEPTH_TEST;
    public final int SCISSOR_TEST = GLES20.GL_SCISSOR_TEST;
    public final int POLYGON_OFFSET_FILL = GLES20.GL_POLYGON_OFFSET_FILL;
    public final int SAMPLE_ALPHA_TO_COVERAGE = GLES20.GL_SAMPLE_ALPHA_TO_COVERAGE;
    public final int SAMPLE_COVERAGE = GLES20.GL_SAMPLE_COVERAGE;
    public final int NO_ERROR = GLES20.GL_NO_ERROR;
    public final int INVALID_ENUM = GLES20.GL_INVALID_ENUM;
    public final int INVALID_VALUE = GLES20.GL_INVALID_VALUE;
    public final int INVALID_OPERATION = GLES20.GL_INVALID_OPERATION;
    public final int OUT_OF_MEMORY = GLES20.GL_OUT_OF_MEMORY;
    public final int CW = GLES20.GL_CW;
    public final int CCW = GLES20.GL_CCW;
    public final int LINE_WIDTH = GLES20.GL_LINE_WIDTH;
    public final int ALIASED_POINT_SIZE_RANGE = GLES20.GL_ALIASED_POINT_SIZE_RANGE;
    public final int ALIASED_LINE_WIDTH_RANGE = GLES20.GL_ALIASED_LINE_WIDTH_RANGE;
    public final int CULL_FACE_MODE = GLES20.GL_CULL_FACE_MODE;
    public final int FRONT_FACE = GLES20.GL_FRONT_FACE;
    public final int DEPTH_RANGE = GLES20.GL_DEPTH_RANGE;
    public final int DEPTH_WRITEMASK = GLES20.GL_DEPTH_WRITEMASK;
    public final int DEPTH_CLEAR_VALUE = GLES20.GL_DEPTH_CLEAR_VALUE;
    public final int DEPTH_FUNC = GLES20.GL_DEPTH_FUNC;
    public final int STENCIL_CLEAR_VALUE = GLES20.GL_STENCIL_CLEAR_VALUE;
    public final int STENCIL_FUNC = GLES20.GL_STENCIL_FUNC;
    public final int STENCIL_FAIL = GLES20.GL_STENCIL_FAIL;
    public final int STENCIL_PASS_DEPTH_FAIL = GLES20.GL_STENCIL_PASS_DEPTH_FAIL;
    public final int STENCIL_PASS_DEPTH_PASS = GLES20.GL_STENCIL_PASS_DEPTH_PASS;
    public final int STENCIL_REF = GLES20.GL_STENCIL_REF;
    public final int STENCIL_VALUE_MASK = GLES20.GL_STENCIL_VALUE_MASK;
    public final int STENCIL_WRITEMASK = GLES20.GL_STENCIL_WRITEMASK;
    public final int STENCIL_BACK_FUNC = GLES20.GL_STENCIL_BACK_FUNC;
    public final int STENCIL_BACK_FAIL = GLES20.GL_STENCIL_BACK_FAIL;
    public final int STENCIL_BACK_PASS_DEPTH_FAIL = GLES20.GL_STENCIL_BACK_PASS_DEPTH_FAIL;
    public final int STENCIL_BACK_PASS_DEPTH_PASS = GLES20.GL_STENCIL_BACK_PASS_DEPTH_PASS;
    public final int STENCIL_BACK_REF = GLES20.GL_STENCIL_BACK_REF;
    public final int STENCIL_BACK_VALUE_MASK = GLES20.GL_STENCIL_BACK_VALUE_MASK;
    public final int STENCIL_BACK_WRITEMASK = GLES20.GL_STENCIL_BACK_WRITEMASK;
    public final int VIEWPORT = GLES20.GL_VIEWPORT;
    public final int SCISSOR_BOX = GLES20.GL_SCISSOR_BOX;
    public final int COLOR_CLEAR_VALUE = GLES20.GL_COLOR_CLEAR_VALUE;
    public final int COLOR_WRITEMASK = GLES20.GL_COLOR_WRITEMASK;
    public final int UNPACK_ALIGNMENT = GLES20.GL_UNPACK_ALIGNMENT;
    public final int PACK_ALIGNMENT = GLES20.GL_PACK_ALIGNMENT;
    public final int MAX_TEXTURE_SIZE = GLES20.GL_MAX_TEXTURE_SIZE;
    public final int MAX_VIEWPORT_DIMS = GLES20.GL_MAX_VIEWPORT_DIMS;
    public final int SUBPIXEL_BITS = GLES20.GL_SUBPIXEL_BITS;
    public final int RED_BITS = GLES20.GL_RED_BITS;
    public final int GREEN_BITS = GLES20.GL_GREEN_BITS;
    public final int BLUE_BITS = GLES20.GL_BLUE_BITS;
    public final int ALPHA_BITS = GLES20.GL_ALPHA_BITS;
    public final int DEPTH_BITS = GLES20.GL_DEPTH_BITS;
    public final int STENCIL_BITS = GLES20.GL_STENCIL_BITS;
    public final int POLYGON_OFFSET_UNITS = GLES20.GL_POLYGON_OFFSET_UNITS;
    public final int POLYGON_OFFSET_FACTOR = GLES20.GL_POLYGON_OFFSET_FACTOR;
    public final int TEXTURE_BINDING_2D = GLES20.GL_TEXTURE_BINDING_2D;
    public final int SAMPLE_BUFFERS = GLES20.GL_SAMPLE_BUFFERS;
    public final int SAMPLES = GLES20.GL_SAMPLES;
    public final int SAMPLE_COVERAGE_VALUE = GLES20.GL_SAMPLE_COVERAGE_VALUE;
    public final int SAMPLE_COVERAGE_INVERT = GLES20.GL_SAMPLE_COVERAGE_INVERT;
    public final int NUM_COMPRESSED_TEXTURE_FORMATS = GLES20.GL_NUM_COMPRESSED_TEXTURE_FORMATS;
    public final int COMPRESSED_TEXTURE_FORMATS = GLES20.GL_COMPRESSED_TEXTURE_FORMATS;
    public final int DONT_CARE = GLES20.GL_DONT_CARE;
    public final int FASTEST = GLES20.GL_FASTEST;
    public final int NICEST = GLES20.GL_NICEST;
    public final int GENERATE_MIPMAP_HINT = GLES20.GL_GENERATE_MIPMAP_HINT;
    public final int BYTE = GLES20.GL_BYTE;
    public final int UNSIGNED_BYTE = GLES20.GL_UNSIGNED_BYTE;
    public final int SHORT = GLES20.GL_SHORT;
    public final int UNSIGNED_SHORT = GLES20.GL_UNSIGNED_SHORT;
    public final int INT = GLES20.GL_INT;
    public final int UNSIGNED_INT = GLES20.GL_UNSIGNED_INT;
    public final int FLOAT = GLES20.GL_FLOAT;
    public final int FIXED = GLES20.GL_FIXED;
    public final int DEPTH_COMPONENT = GLES20.GL_DEPTH_COMPONENT;
    public final int ALPHA = GLES20.GL_ALPHA;
    public final int RGB = GLES20.GL_RGB;
    public final int RGBA = GLES20.GL_RGBA;
    public final int LUMINANCE = GLES20.GL_LUMINANCE;
    public final int LUMINANCE_ALPHA = GLES20.GL_LUMINANCE_ALPHA;
    public final int UNSIGNED_SHORT_4_4_4_4 = GLES20.GL_UNSIGNED_SHORT_4_4_4_4;
    public final int UNSIGNED_SHORT_5_5_5_1 = GLES20.GL_UNSIGNED_SHORT_5_5_5_1;
    public final int UNSIGNED_SHORT_5_6_5 = GLES20.GL_UNSIGNED_SHORT_5_6_5;
    public final int FRAGMENT_SHADER = GLES20.GL_FRAGMENT_SHADER;
    public final int VERTEX_SHADER = GLES20.GL_VERTEX_SHADER;
    public final int MAX_VERTEX_ATTRIBS = GLES20.GL_MAX_VERTEX_ATTRIBS;
    public final int MAX_VERTEX_UNIFORM_VECTORS = GLES20.GL_MAX_VERTEX_UNIFORM_VECTORS;
    public final int MAX_VARYING_VECTORS = GLES20.GL_MAX_VARYING_VECTORS;
    public final int MAX_COMBINED_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;
    public final int MAX_VERTEX_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
    public final int MAX_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_TEXTURE_IMAGE_UNITS;
    public final int MAX_FRAGMENT_UNIFORM_VECTORS = GLES20.GL_MAX_FRAGMENT_UNIFORM_VECTORS;
    public final int SHADER_TYPE = GLES20.GL_SHADER_TYPE;
    public final int DELETE_STATUS = GLES20.GL_DELETE_STATUS;
    public final int LINK_STATUS = GLES20.GL_LINK_STATUS;
    public final int VALIDATE_STATUS = GLES20.GL_VALIDATE_STATUS;
    public final int ATTACHED_SHADERS = GLES20.GL_ATTACHED_SHADERS;
    public final int ACTIVE_UNIFORMS = GLES20.GL_ACTIVE_UNIFORMS;
    public final int ACTIVE_UNIFORM_MAX_LENGTH = GLES20.GL_ACTIVE_UNIFORM_MAX_LENGTH;
    public final int ACTIVE_ATTRIBUTES = GLES20.GL_ACTIVE_ATTRIBUTES;
    public final int ACTIVE_ATTRIBUTE_MAX_LENGTH = GLES20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH;
    public final int SHADING_LANGUAGE_VERSION = GLES20.GL_SHADING_LANGUAGE_VERSION;
    public final int CURRENT_PROGRAM = GLES20.GL_CURRENT_PROGRAM;
    public final int NEVER = GLES20.GL_NEVER;
    public final int LESS = GLES20.GL_LESS;
    public final int EQUAL = GLES20.GL_EQUAL;
    public final int LEQUAL = GLES20.GL_LEQUAL;
    public final int GREATER = GLES20.GL_GREATER;
    public final int NOTEQUAL = GLES20.GL_NOTEQUAL;
    public final int GEQUAL = GLES20.GL_GEQUAL;
    public final int ALWAYS = GLES20.GL_ALWAYS;
    public final int KEEP = GLES20.GL_KEEP;
    public final int REPLACE = GLES20.GL_REPLACE;
    public final int INCR = GLES20.GL_INCR;
    public final int DECR = GLES20.GL_DECR;
    public final int INVERT = GLES20.GL_INVERT;
    public final int INCR_WRAP = GLES20.GL_INCR_WRAP;
    public final int DECR_WRAP = GLES20.GL_DECR_WRAP;
    public final int VENDOR = GLES20.GL_VENDOR;
    public final int RENDERER = GLES20.GL_RENDERER;
    public final int VERSION = GLES20.GL_VERSION;
    public final int EXTENSIONS = GLES20.GL_EXTENSIONS;
    public final int NEAREST = GLES20.GL_NEAREST;
    public final int LINEAR = GLES20.GL_LINEAR;
    public final int NEAREST_MIPMAP_NEAREST = GLES20.GL_NEAREST_MIPMAP_NEAREST;
    public final int LINEAR_MIPMAP_NEAREST = GLES20.GL_LINEAR_MIPMAP_NEAREST;
    public final int NEAREST_MIPMAP_LINEAR = GLES20.GL_NEAREST_MIPMAP_LINEAR;
    public final int LINEAR_MIPMAP_LINEAR = GLES20.GL_LINEAR_MIPMAP_LINEAR;
    public final int TEXTURE_MAG_FILTER = GLES20.GL_TEXTURE_MAG_FILTER;
    public final int TEXTURE_MIN_FILTER = GLES20.GL_TEXTURE_MIN_FILTER;
    public final int TEXTURE_WRAP_S = GLES20.GL_TEXTURE_WRAP_S;
    public final int TEXTURE_WRAP_T = GLES20.GL_TEXTURE_WRAP_T;
    public final int TEXTURE = GLES20.GL_TEXTURE;
    public final int TEXTURE_CUBE_MAP = GLES20.GL_TEXTURE_CUBE_MAP;
    public final int TEXTURE_BINDING_CUBE_MAP = GLES20.GL_TEXTURE_BINDING_CUBE_MAP;
    public final int TEXTURE_CUBE_MAP_POSITIVE_X = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
    public final int TEXTURE_CUBE_MAP_NEGATIVE_X = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
    public final int TEXTURE_CUBE_MAP_POSITIVE_Y = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
    public final int TEXTURE_CUBE_MAP_NEGATIVE_Y = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
    public final int TEXTURE_CUBE_MAP_POSITIVE_Z = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
    public final int TEXTURE_CUBE_MAP_NEGATIVE_Z = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;
    public final int MAX_CUBE_MAP_TEXTURE_SIZE = GLES20.GL_MAX_CUBE_MAP_TEXTURE_SIZE;
    public final int TEXTURE0 = GLES20.GL_TEXTURE0;
    public final int TEXTURE1 = GLES20.GL_TEXTURE1;
    public final int TEXTURE2 = GLES20.GL_TEXTURE2;
    public final int TEXTURE3 = GLES20.GL_TEXTURE3;
    public final int TEXTURE4 = GLES20.GL_TEXTURE4;
    public final int TEXTURE5 = GLES20.GL_TEXTURE5;
    public final int TEXTURE6 = GLES20.GL_TEXTURE6;
    public final int TEXTURE7 = GLES20.GL_TEXTURE7;
    public final int TEXTURE8 = GLES20.GL_TEXTURE8;
    public final int TEXTURE9 = GLES20.GL_TEXTURE9;
    public final int TEXTURE10 = GLES20.GL_TEXTURE10;
    public final int TEXTURE11 = GLES20.GL_TEXTURE11;
    public final int TEXTURE12 = GLES20.GL_TEXTURE12;
    public final int TEXTURE13 = GLES20.GL_TEXTURE13;
    public final int TEXTURE14 = GLES20.GL_TEXTURE14;
    public final int TEXTURE15 = GLES20.GL_TEXTURE15;
    public final int TEXTURE16 = GLES20.GL_TEXTURE16;
    public final int TEXTURE17 = GLES20.GL_TEXTURE17;
    public final int TEXTURE18 = GLES20.GL_TEXTURE18;
    public final int TEXTURE19 = GLES20.GL_TEXTURE19;
    public final int TEXTURE20 = GLES20.GL_TEXTURE20;
    public final int TEXTURE21 = GLES20.GL_TEXTURE21;
    public final int TEXTURE22 = GLES20.GL_TEXTURE22;
    public final int TEXTURE23 = GLES20.GL_TEXTURE23;
    public final int TEXTURE24 = GLES20.GL_TEXTURE24;
    public final int TEXTURE25 = GLES20.GL_TEXTURE25;
    public final int TEXTURE26 = GLES20.GL_TEXTURE26;
    public final int TEXTURE27 = GLES20.GL_TEXTURE27;
    public final int TEXTURE28 = GLES20.GL_TEXTURE28;
    public final int TEXTURE29 = GLES20.GL_TEXTURE29;
    public final int TEXTURE30 = GLES20.GL_TEXTURE30;
    public final int TEXTURE31 = GLES20.GL_TEXTURE31;
    public final int REPEAT = GLES20.GL_REPEAT;
    public final int CLAMP_TO_EDGE = GLES20.GL_CLAMP_TO_EDGE;
    public final int MIRRORED_REPEAT = GLES20.GL_MIRRORED_REPEAT;
    public final int FLOAT_VEC2 = GLES20.GL_FLOAT_VEC2;
    public final int FLOAT_VEC3 = GLES20.GL_FLOAT_VEC3;
    public final int FLOAT_VEC4 = GLES20.GL_FLOAT_VEC4;
    public final int INT_VEC2 = GLES20.GL_INT_VEC2;
    public final int INT_VEC3 = GLES20.GL_INT_VEC3;
    public final int INT_VEC4 = GLES20.GL_INT_VEC4;
    public final int BOOL = GLES20.GL_BOOL;
    public final int BOOL_VEC2 = GLES20.GL_BOOL_VEC2;
    public final int BOOL_VEC3 = GLES20.GL_BOOL_VEC3;
    public final int BOOL_VEC4 = GLES20.GL_BOOL_VEC4;
    public final int FLOAT_MAT2 = GLES20.GL_FLOAT_MAT2;
    public final int FLOAT_MAT3 = GLES20.GL_FLOAT_MAT3;
    public final int FLOAT_MAT4 = GLES20.GL_FLOAT_MAT4;
    public final int SAMPLER_2D = GLES20.GL_SAMPLER_2D;
    public final int SAMPLER_CUBE = GLES20.GL_SAMPLER_CUBE;
    public final int VERTEX_ATTRIB_ARRAY_ENABLED = GLES20.GL_VERTEX_ATTRIB_ARRAY_ENABLED;
    public final int VERTEX_ATTRIB_ARRAY_SIZE = GLES20.GL_VERTEX_ATTRIB_ARRAY_SIZE;
    public final int VERTEX_ATTRIB_ARRAY_STRIDE = GLES20.GL_VERTEX_ATTRIB_ARRAY_STRIDE;
    public final int VERTEX_ATTRIB_ARRAY_TYPE = GLES20.GL_VERTEX_ATTRIB_ARRAY_TYPE;
    public final int VERTEX_ATTRIB_ARRAY_NORMALIZED = GLES20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
    public final int VERTEX_ATTRIB_ARRAY_POINTER = GLES20.GL_VERTEX_ATTRIB_ARRAY_POINTER;
    public final int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = GLES20.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
    public final int IMPLEMENTATION_COLOR_READ_TYPE = GLES20.GL_IMPLEMENTATION_COLOR_READ_TYPE;
    public final int IMPLEMENTATION_COLOR_READ_FORMAT = GLES20.GL_IMPLEMENTATION_COLOR_READ_FORMAT;
    public final int COMPILE_STATUS = GLES20.GL_COMPILE_STATUS;
    public final int INFO_LOG_LENGTH = GLES20.GL_INFO_LOG_LENGTH;
    public final int SHADER_SOURCE_LENGTH = GLES20.GL_SHADER_SOURCE_LENGTH;
    public final int SHADER_COMPILER = GLES20.GL_SHADER_COMPILER;
    public final int SHADER_BINARY_FORMATS = GLES20.GL_SHADER_BINARY_FORMATS;
    public final int NUM_SHADER_BINARY_FORMATS = GLES20.GL_NUM_SHADER_BINARY_FORMATS;
    public final int LOW_FLOAT = GLES20.GL_LOW_FLOAT;
    public final int MEDIUM_FLOAT = GLES20.GL_MEDIUM_FLOAT;
    public final int HIGH_FLOAT = GLES20.GL_HIGH_FLOAT;
    public final int LOW_INT = GLES20.GL_LOW_INT;
    public final int MEDIUM_INT = GLES20.GL_MEDIUM_INT;
    public final int HIGH_INT = GLES20.GL_HIGH_INT;
    public final int FRAMEBUFFER = GLES20.GL_FRAMEBUFFER;
    public final int RENDERBUFFER = GLES20.GL_RENDERBUFFER;
    public final int RGBA4 = GLES20.GL_RGBA4;
    public final int RGB5_A1 = GLES20.GL_RGB5_A1;
    public final int RGB565 = GLES20.GL_RGB565;
    public final int DEPTH_COMPONENT16 = GLES20.GL_DEPTH_COMPONENT16;
    public final int STENCIL_INDEX = GLES20.GL_STENCIL_INDEX;
    public final int STENCIL_INDEX8 = GLES20.GL_STENCIL_INDEX8;
    public final int RENDERBUFFER_WIDTH = GLES20.GL_RENDERBUFFER_WIDTH;
    public final int RENDERBUFFER_HEIGHT = GLES20.GL_RENDERBUFFER_HEIGHT;
    public final int RENDERBUFFER_INTERNAL_FORMAT = GLES20.GL_RENDERBUFFER_INTERNAL_FORMAT;
    public final int RENDERBUFFER_RED_SIZE = GLES20.GL_RENDERBUFFER_RED_SIZE;
    public final int RENDERBUFFER_GREEN_SIZE = GLES20.GL_RENDERBUFFER_GREEN_SIZE;
    public final int RENDERBUFFER_BLUE_SIZE = GLES20.GL_RENDERBUFFER_BLUE_SIZE;
    public final int RENDERBUFFER_ALPHA_SIZE = GLES20.GL_RENDERBUFFER_ALPHA_SIZE;
    public final int RENDERBUFFER_DEPTH_SIZE = GLES20.GL_RENDERBUFFER_DEPTH_SIZE;
    public final int RENDERBUFFER_STENCIL_SIZE = GLES20.GL_RENDERBUFFER_STENCIL_SIZE;
    public final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = GLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
    public final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = GLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
    public final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = GLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
    public final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = GLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
    public final int COLOR_ATTACHMENT0 = GLES20.GL_COLOR_ATTACHMENT0;
    public final int DEPTH_ATTACHMENT = GLES20.GL_DEPTH_ATTACHMENT;
    public final int STENCIL_ATTACHMENT = GLES20.GL_STENCIL_ATTACHMENT;
    public final int NONE = GLES20.GL_NONE;
    public final int FRAMEBUFFER_COMPLETE = GLES20.GL_FRAMEBUFFER_COMPLETE;
    public final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT = GLES20.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
    public final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = GLES20.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
    public final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS = GLES20.GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
    public final int FRAMEBUFFER_UNSUPPORTED = GLES20.GL_FRAMEBUFFER_UNSUPPORTED;
    public final int FRAMEBUFFER_BINDING = GLES20.GL_FRAMEBUFFER_BINDING;
    public final int RENDERBUFFER_BINDING = GLES20.GL_RENDERBUFFER_BINDING;
    public final int MAX_RENDERBUFFER_SIZE = GLES20.GL_MAX_RENDERBUFFER_SIZE;
    public final int INVALID_FRAMEBUFFER_OPERATION = GLES20.GL_INVALID_FRAMEBUFFER_OPERATION;

    private final int BYTES_PER_FLOAT_32 = 4;
    private final int BYTES_PER_INT_32 = 4;
    private final int BYTES_PER_INT_16 = 2;

    private V8 runtime;

    private final GLObjects glObjects;
    private final FilesResourceManager files;

    public WebGLRenderingContext(V8 runtime, GLObjects glObjects, FilesResourceManager files) {
        this.runtime = runtime;
        this.glObjects = glObjects;
        this.files = files;
    }

    public void activeTexture(
            int texture
    ) {
        GLES20.glActiveTexture(texture);
    }

    // c function void attachShader ( gLuint program, gLuint shader )

    public void attachShader(
            V8Object program,
            V8Object shader
    ) {
        GLES20.glAttachShader(glObjects.getId(program), glObjects.getId(shader));
    }

    // c function void bindAttribLocation ( gLuint program, gLuint index.js, const char *name )

    public void bindAttribLocation(
            V8Object program,
            int index,
            String name
    ) {
        GLES20.glBindAttribLocation(glObjects.getId(program), index, name);
    }

    // c function void bindBuffer ( gLenum target, gLuint buffer )

    public void bindBuffer(
            int target,
            V8Object buffer
    ) {
        if (buffer==null) GLES20.glBindBuffer(target, 0);
        else GLES20.glBindBuffer(target, glObjects.getId(buffer));
    }

    // c function void bindFramebuffer ( gLenum target, gLuint framebuffer )

    public void bindFramebuffer(
            int target,
            V8Object framebuffer
    ) {
        if (framebuffer==null) GLES20.glBindFramebuffer(target,0);
        else GLES20.glBindFramebuffer(target,glObjects.getId(framebuffer));
    }

    // c function void bindRenderbuffer ( gLenum target, gLuint renderbuffer )

    public void bindRenderbuffer(
            int target,
            V8Object renderbuffer
    ) {
        if (renderbuffer==null) GLES20.glBindRenderbuffer(target,0);
        else GLES20.glBindRenderbuffer(target,glObjects.getId(renderbuffer));
    }

    // c function void bindTexture ( gLenum target, gLuint texture )

    public void bindTexture(
            int target,
            V8Object texture
    ) {
        if (texture==null) GLES20.glBindTexture(target,0);
        else GLES20.glBindTexture(target,glObjects.getId(texture));
    }

    // c function void blendColor ( gLclampf red, gLclampf green, gLclampf blue, gLclampf alpha )

    public void blendColor(
            float red,
            float green,
            float blue,
            float alpha
    ) {
        GLES20.glBlendColor(red,green,blue,alpha);
    }

    // c function void blendEquation ( gLenum mode )

    public void blendEquation(
            int mode
    ) {
        GLES20.glBlendEquation(mode);
    }

    // c function void blendEquationSeparate ( gLenum modeRGB, gLenum modeAlpha )

    public void blendEquationSeparate(
            int modeRGB,
            int modeAlpha
    ) {
        GLES20.glBlendEquationSeparate(modeRGB,modeAlpha);
    }

    // c function void blendFunc ( gLenum sfactor, gLenum dfactor )

    public void blendFunc(
            int sfactor,
            int dfactor
    ) {
        GLES20.glBlendFunc(sfactor,dfactor);
    }

    // c function void blendFuncSeparate ( gLenum srcRGB, gLenum dstRGB, gLenum srcAlpha, gLenum dstAlpha )

    public void blendFuncSeparate(
            int srcRGB,
            int dstRGB,
            int srcAlpha,
            int dstAlpha
    ) {
        GLES20.glBlendFuncSeparate(srcRGB,dstRGB,srcAlpha,dstAlpha);
    }

    // c function void bufferData ( gLenum target, gLsizeiptr size, const gLvoid *data, gLenum usage )

    public void bufferData(
            int target,
            V8TypedArray data,
            int usage
    ) {
        switch (data.getType()) {
            case V8Value.FLOAT_32_ARRAY: {
                GLES20.glBufferData(target,data.length()*BYTES_PER_FLOAT_32,data.getByteBuffer().asFloatBuffer(),usage);
                break;
            }
            case V8Value.UNSIGNED_INT_16_ARRAY: {
                GLES20.glBufferData(target,data.length()*BYTES_PER_INT_16,data.getByteBuffer().asIntBuffer(),usage);
                break;
            }
            default: {
                throw new RuntimeException("can not invoke bufferData: wrong array type");
            }
        }

    }


    // c function void bufferSubData ( gLenum target, gLintptr offset, gLsizeiptr size, const gLvoid *data )

    public void bufferSubData(
            int target,
            int offset,
            V8TypedArray data
    ) {
        switch (data.getType()) {
            case V8Value.FLOAT_32_ARRAY: {
                GLES20.glBufferSubData(target,offset,data.length(),data.getByteBuffer().asFloatBuffer());
                break;
            }
            default: {
                throw new RuntimeException("can not invoke bufferData: wrong array type");
            }
        }
    }

    // c function gLenum checkFramebufferStatus ( gLenum target )

    public int checkFramebufferStatus(
            int target
    ) {
        return GLES20.glCheckFramebufferStatus(target);
    }

    // c function void clear ( gLbitfield mask )

    public void clear(
            int mask
    ) {
        GLES20.glClear(mask);
    }

    // c function void clearColor ( gLclampf red, gLclampf green, gLclampf blue, gLclampf alpha )

    public void clearColor(
            double red,
            double green,
            double blue,
            double alpha
    ) {
        GLES20.glClearColor((float) red,(float) green,(float) blue,(float) alpha);
    }

    // c function void clearDepthf ( gLclampf depth ) - not implemented in webgl

//    public void clearDepthf(
//            float depth
//    ) {
//    }

    // c function void clearStencil ( gLint s )

    public void clearStencil(
            int s
    ) {
        GLES20.glClearStencil(s);
    }

    // c function void colorMask ( gLboolean red, gLboolean green, gLboolean blue, gLboolean alpha )

    public void colorMask(
            boolean red,
            boolean green,
            boolean blue,
            boolean alpha
    ) {
        GLES20.glColorMask(red,green,blue,alpha);
    }

    // c function void compileShader ( gLuint shader )

    public void compileShader(
            V8Object shader
    ) {
        GLES20.glCompileShader(glObjects.getId(shader));
    }

    // c function void compressedTexImage2D ( gLenum target, gLint level, gLenum internalformat, gLsizei width, gLsizei height, gLint border, gLsizei imageSize, const gLvoid *data )
    // not implemented

    // c function void compressedTexSubImage2D ( gLenum target, gLint level, gLint xoffset, gLint yoffset, gLsizei width, gLsizei height, gLenum format, gLsizei imageSize, const gLvoid *data )
    // not implemented

    // c function void copyTexImage2D ( gLenum target, gLint level, gLenum internalformat, gLint x, gLint y, gLsizei width, gLsizei height, gLint border )

    public void copyTexImage2D(
            int target,
            int level,
            int internalformat,
            int x,
            int y,
            int width,
            int height,
            int border
    ) {
        GLES20.glCopyTexImage2D(target,level,internalformat,x,y,width,height,border);
    }

    // c function void copyTexSubImage2D ( gLenum target, gLint level, gLint xoffset, gLint yoffset, gLint x, gLint y, gLsizei width, gLsizei height )

    public void copyTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int x,
            int y,
            int width,
            int height
    ) {
        GLES20.glCopyTexSubImage2D(target,level,xoffset,yoffset,x,y,width,height);
    }

    // c function gLuint createProgram ( void )

    public V8Object createProgram(
    ) {
        return glObjects.create(GLES20.glCreateProgram());
    }

    // c function gLuint createShader ( gLenum type )

    public V8Object createShader(
            int type
    ) {
        return glObjects.create(GLES20.glCreateShader(type));
    }

    // c function void cullFace ( gLenum mode )

    public void cullFace(
            int mode
    ) {
        GLES20.glCullFace(mode);
    }

    // c function void deleteBuffers ( gLsizei n, const gLuint *buffers )

//    public void deleteBuffers(
//            int n,
//            int[] buffers,
//            int offset
//    ) {
//    }

    // c function void deleteBuffers ( gLsizei n, const gLuint *buffers )

//    public void deleteBuffers(
//            int n,
//            java.nio.IntBuffer buffers
//    ) {
//    }

    // c function void deleteFramebuffers ( gLsizei n, const gLuint *framebuffers )

//    public void deleteFramebuffers(
//            int n,
//            int[] framebuffers,
//            int offset
//    ) {
//    }

    // c function void deleteFramebuffers ( gLsizei n, const gLuint *framebuffers )

//    public void deleteFramebuffers(
//            int n,
//            java.nio.IntBuffer framebuffers
//    ) {
//    }

    // c function void deleteProgram ( gLuint program )

    public void deleteRenderbuffer(V8Object renderbuffer){
        int[] buffers = {glObjects.getId(renderbuffer)};
        GLES20.glDeleteRenderbuffers(1,buffers,0);
    }

    public void deleteBuffer(V8Object buffer){
        int[] buffers = {glObjects.getId(buffer)};
        GLES20.glDeleteBuffers(1,buffers,0);
    }

    public void deleteFramebuffer(V8Object framebuffer){
        int[] buffers = {glObjects.getId(framebuffer)};
        GLES20.glDeleteFramebuffers(1,buffers,0);
    }

    public void deleteProgram(
            V8Object program
    ) {
        GLES20.glDeleteProgram(glObjects.getId(program));
    }

    public void deleteTexture(V8Object texture){
        int[] buffers = {glObjects.getId(texture)};
        GLES20.glDeleteTextures(1,buffers,0);
    }

    // c function void deleteRenderbuffers ( gLsizei n, const gLuint *renderbuffers )

//    public void deleteRenderbuffers(
//            int n,
//            int[] renderbuffers,
//            int offset
//    ) {
//    }

    // c function void deleteRenderbuffers ( gLsizei n, const gLuint *renderbuffers )

//    public void deleteRenderbuffers(
//            int n,
//            java.nio.IntBuffer renderbuffers
//    ) {
//    }

    // c function void deleteShader ( gLuint shader )

    public void deleteShader(
            V8Object shader
    ) {
        GLES20.glDeleteShader(glObjects.getId(shader));
    }

    // c function void deleteTextures ( gLsizei n, const gLuint *textures )

//    public void deleteTextures(
//            int n,
//            int[] textures,
//            int offset
//    ) {
//    }

    // c function void deleteTextures ( gLsizei n, const gLuint *textures )

//    public void deleteTextures(
//            int n,
//            java.nio.IntBuffer textures
//    ) {
//    }

    // c function void depthFunc ( gLenum func )

    public void depthFunc(
            int func
    ) {
        GLES20.glDepthFunc(func);
    }

    // c function void depthMask ( gLboolean flag )

    public void depthMask(
            boolean flag
    ) {
        GLES20.glDepthMask(flag);
    }

    // c function void depthRangef ( gLclampf zNear, gLclampf zFar )

    public void depthRange(
            double zNear,
            double zFar
    ) {
        GLES20.glDepthRangef((float) zNear,(float) zFar);
    }

    // c function void detachShader ( gLuint program, gLuint shader )

    public void detachShader(
            V8Object program,
            V8Object shader
    ) {
        GLES20.glDetachShader(glObjects.getId(program),glObjects.getId(shader));
    }

    // c function void disable ( gLenum cap )

    public void disable(
            int cap
    ) {
        GLES20.glDisable(cap);
    }

    // c function void disableVertexAttribArray ( gLuint index.js )

    public void disableVertexAttribArray(
            int index
    ) {
        GLES20.glDisableVertexAttribArray(index);
    }

    // c function void drawArrays ( gLenum mode, gLint first, gLsizei count )

    public void drawArrays(
            int mode,
            int first,
            int count
    ) {
        GLES20.glDrawArrays(mode,first,count);
    }

    // c function void drawElements ( gLenum mode, gLsizei count, gLenum type, gLint offset )

    public void drawElements(
            int mode,
            int count,
            int type,
            int offset
    ) {
        GLES20.glDrawElements(mode,count,type,offset);
    }

    // c function void drawElements ( gLenum mode, gLsizei count, gLenum type, const gLvoid *indices )

//    public void drawElements(
//            int mode,
//            int count,
//            int type,
//            java.nio.Buffer indices
//    ) {
//    }

    // c function void enable ( gLenum cap )

    public void enable(
            int cap
    ) {
        GLES20.glEnable(cap);
    }

    // c function void enableVertexAttribArray ( gLuint index.js )

    public void enableVertexAttribArray(
            int index
    ) {
        GLES20.glEnableVertexAttribArray(index);
    }

    // c function void finish ( void )

    public void finish(
    ) {
        GLES20.glFinish();
    }

    // c function void flush ( void )

    public void flush(
    ) {
        GLES20.glFlush();
    }

    // c function void framebufferRenderbuffer ( gLenum target, gLenum attachment, gLenum renderbuffertarget, gLuint renderbuffer )

    public void framebufferRenderbuffer(
            int target,
            int attachment,
            int renderbuffertarget,
            V8Object renderbuffer
    ) {
        GLES20.glFramebufferRenderbuffer(target,attachment,renderbuffertarget,glObjects.getId(renderbuffer));
    }

    // c function void framebufferTexture2D ( gLenum target, gLenum attachment, gLenum textarget, gLuint texture, gLint level )

    public void framebufferTexture2D(
            int target,
            int attachment,
            int textarget,
            V8Object texture,
            int level
    ) {
        GLES20.glFramebufferTexture2D(target,attachment,textarget,glObjects.getId(texture),level);
    }

    // c function void frontFace ( gLenum mode )

    public void frontFace(
            int mode
    ) {
        GLES20.glFrontFace(mode);
    }

    // c function void genBuffers ( gLsizei n, gLuint *buffers )

//    public void genBuffers(
//            int n,
//            int[] buffers,
//            int offset
//    ) {
//    }

    // c function void genBuffers ( gLsizei n, gLuint *buffers )

//    public void genBuffers(
//            int n,
//            java.nio.IntBuffer buffers
//    ) {
//    }

    // c function void generateMipmap ( gLenum target )

    public void generateMipmap(
            int target
    ) {
        GLES20.glGenerateMipmap(target);
    }

    // c function void genFramebuffers ( gLsizei n, gLuint *framebuffers )

    public void genFramebuffers(
            int n,
            int[] framebuffers,
            int offset
    ) {
    }

    // c function void genFramebuffers ( gLsizei n, gLuint *framebuffers )

//    public void genFramebuffers(
//            int n,
//            java.nio.IntBuffer framebuffers
//    ) {
//    }

    // c function void genRenderbuffers ( gLsizei n, gLuint *renderbuffers )

//    public void genRenderbuffers(
//            int n,
//            int[] renderbuffers,
//            int offset
//    ) {
//    }

    // c function void genRenderbuffers ( gLsizei n, gLuint *renderbuffers )

//    public void genRenderbuffers(
//            int n,
//            java.nio.IntBuffer renderbuffers
//    ) {
//    }

    // c function void genTextures ( gLsizei n, gLuint *textures )

//    public void genTextures(
//            int n,
//            int[] textures,
//            int offset
//    ) {
//    }

    // c function void genTextures ( gLsizei n, gLuint *textures )

//    public void genTextures(
//            int n,
//            java.nio.IntBuffer textures
//    ) {
//    }

    // c function void getActiveAttrib ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

//    public void getActiveAttrib(
//            int program,
//            int index.js,
//            int bufsize,
//            int[] length,
//            int lengthOffset,
//            int[] size,
//            int sizeOffset,
//            int[] type,
//            int typeOffset,
//            byte[] name,
//            int nameOffset
//    ) {
//    }

    // c function void getActiveAttrib ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

    /**
     * @hide method is broken, but used to be public (b/6006380)
     */
//  @UnsupportedAppUsage
//  public   void getActiveAttrib(
//      int program,
//      int index.js,
//      int bufsize,
//      java.nio.IntBuffer length,
//      java.nio.IntBuffer size,
//      java.nio.IntBuffer type,
//      byte name
//  ) {}

    // c function void getActiveAttrib ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )
    public V8Object getActiveAttrib(
            V8Object program,
            int index
    ) {
        int[] size = new int[1];
        int[] type = new int[1];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            String name = GLES20.glGetActiveAttrib(glObjects.getId(program),index,size,0,type,0);
            V8Object result = new V8Object(runtime);
            result.add("name",name);
            result.add("type",type[0]);
            result.add("size",size[0]);
            return result;
        } else {
            throw new RuntimeException("minimal supported version of android is 4.2");
        }

    }

    // c function void getActiveAttrib ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

//    public String getActiveAttrib(
//            int program,
//            int index.js,
//            java.nio.IntBuffer size,
//            java.nio.IntBuffer type
//    ) {
//        return "";
//    }

    // c function void getActiveUniform ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

//    public void getActiveUniform(
//            int program,
//            int index.js,
//            int bufsize,
//            int[] length,
//            int lengthOffset,
//            int[] size,
//            int sizeOffset,
//            int[] type,
//            int typeOffset,
//            byte[] name,
//            int nameOffset
//    ) {
//    }

    // c function void getActiveUniform ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

    /**
     * @hide method is broken, but used to be public (b/6006380)
     */
//  @UnsupportedAppUsage
//  public   void getActiveUniform(
//      int program,
//      int index.js,
//      int bufsize,
//      java.nio.IntBuffer length,
//      java.nio.IntBuffer size,
//      java.nio.IntBuffer type,
//      byte name
//  ) {}


    // c function void getActiveUniform ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )
    public V8Object getActiveUniform(
            V8Object program,
            int index
    ) {
        int[] size = new int[1];
        int[] type = new int[1];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            String name = GLES20.glGetActiveUniform(glObjects.getId(program),index,size,0,type,0);
            V8Object result = new V8Object(runtime);
            result.add("name",name);
            result.add("type",type[0]);
            result.add("size",size[0]);
            return result;
        } else {
            throw new RuntimeException("minimal supported version of android is 4.2");
        }
    }

    // c function void getActiveUniform ( gLuint program, gLuint index.js, gLsizei bufsize, gLsizei *length, gLint *size, gLenum *type, char *name )

//    public String getActiveUniform(
//            int program,
//            int index.js,
//            java.nio.IntBuffer size,
//            java.nio.IntBuffer type
//    ) {
//        return "";
//    }
    // c function void getAttachedShaders ( gLuint program, gLsizei maxcount, gLsizei *count, gLuint *shaders )

//    public void getAttachedShaders(
//            int program,
//            int maxcount,
//            int[] count,
//            int countOffset,
//            int[] shaders,
//            int shadersOffset
//    ) {
//    }
    // todo not implemented for now

    // c function void getAttachedShaders ( gLuint program, gLsizei maxcount, gLsizei *count, gLuint *shaders )

//    public void getAttachedShaders(
//            int program,
//            int maxcount,
//            java.nio.IntBuffer count,
//            java.nio.IntBuffer shaders
//    ) {
//
//    }

    // c function gLint getAttribLocation ( gLuint program, const char *name )

    public int getAttribLocation(
            V8Object program,
            String name
    ) {
        return GLES20.glGetAttribLocation(glObjects.getId(program),name);
    }

    // c function void getBooleanv ( gLenum pname, gLboolean *params )

//    public void getBooleanv(
//            int pname,
//            boolean[] params,
//            int offset
//    ) {
//    }

    // c function void getBooleanv ( gLenum pname, gLboolean *params )

//    public void getBooleanv(
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getBufferParameteriv ( gLenum target, gLenum pname, gLint *params )

//    public void getBufferParameteriv(
//            int target,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getBufferParameteriv ( gLenum target, gLenum pname, gLint *params )

//    public void getBufferParameteriv(
//            int target,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function gLenum getError ( void )

    public int getError(
    ) {
        return GLES20.glGetError();
    }

    // c function void getFloatv ( gLenum pname, gLfloat *params )

//    public void getFloatv(
//            int pname,
//            float[] params,
//            int offset
//    ) {
//    }

    // c function void getFloatv ( gLenum pname, gLfloat *params )

//    public void getFloatv(
//            int pname,
//            java.nio.FloatBuffer params
//    ) {
//    }

    // c function void getFramebufferAttachmentParameteriv ( gLenum target, gLenum attachment, gLenum pname, gLint *params )

    public int getFramebufferAttachmentParameteriv(
            int target,
            int attachment,
            int pname
    ) {
        int[] params = new int[1];
        GLES20.glGetFramebufferAttachmentParameteriv(target,attachment,pname,params,0);
        return params[0];
    }

    private int getIntParameter(int glEnum){
        int[] params = new int[1];
        GLES20.glGetIntegerv(glEnum, params, 0);
        return params[0];
    }

    public Object getParameter(int glEnum){
        return getIntParameter(glEnum);
    }

    public V8Object createTexture(){
        int[] texId = new int[1];
        GLES20.glGenTextures(1, texId, 0);
        return glObjects.create(texId[0]);
    }

    // c function void getFramebufferAttachmentParameteriv ( gLenum target, gLenum attachment, gLenum pname, gLint *params )

//    public void getFramebufferAttachmentParameteriv(
//            int target,
//            int attachment,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getIntegerv ( gLenum pname, gLint *params )

//    public void getIntegerv(
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getIntegerv ( gLenum pname, gLint *params )

//    public void getIntegerv(
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getProgramiv ( gLuint program, gLenum pname, gLint *params )

//    public void getProgramiv(
//            int program,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getProgramiv ( gLuint program, gLenum pname, gLint *params )

//    public void getProgramiv(
//            int program,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getProgramInfoLog( gLuint program, gLsizei maxLength, gLsizei * length,
    //   gLchar * infoLog) {}

    public String getProgramInfoLog(
            V8Object program
    ) {
        return GLES20.glGetProgramInfoLog(glObjects.getId(program));
    }
    // c function void getRenderbufferParameteriv ( gLenum target, gLenum pname, gLint *params )

    public int getRenderbufferParameter(
            int target,
            int pname
    ) {
        int[] params = new int[1];
        GLES20.glGetRenderbufferParameteriv(target,pname,params,0);
        return params[0];
    }

    // c function void getRenderbufferParameteriv ( gLenum target, gLenum pname, gLint *params )

//    public void getRenderbufferParameteriv(
//            int target,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getShaderiv ( gLuint shader, gLenum pname, gLint *params )

//    public void getShaderiv(
//            int shader,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getShaderiv ( gLuint shader, gLenum pname, gLint *params )

//    public void getShaderiv(
//            int shader,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getShaderInfoLog( gLuint shader, gLsizei maxLength, gLsizei * length,
    //   gLchar * infoLog) {}

    public String getShaderInfoLog(
            V8Object shader
    ) {
        return GLES20.glGetShaderInfoLog(glObjects.getId(shader));
    }
    // c function void getShaderPrecisionFormat ( gLenum shadertype, gLenum precisiontype, gLint *range, gLint *precision )

    public V8Object getShaderPrecisionFormat(
            int shadertype,
            int precisiontype
    ) {
        int[] range = new int[1];
        int[] precision = new int[1];
        GLES20.glGetShaderPrecisionFormat(shadertype,precisiontype,range,0,precision,0);
        V8Object result = new V8Object(runtime);
        result.add("precision",precision[0]);
        result.add("rangeMin",range[0]);
        result.add("rangeMax",range[0]);
        return result;
    }

    // c function void getShaderPrecisionFormat ( gLenum shadertype, gLenum precisiontype, gLint *range, gLint *precision )

//    public void getShaderPrecisionFormat(
//            int shadertype,
//            int precisiontype,
//            java.nio.IntBuffer range,
//            java.nio.IntBuffer precision
//    ) {
//    }

    // c function void getShaderSource ( gLuint shader, gLsizei bufsize, gLsizei *length, char *source )

//    public void getShaderSource(
//            int shader,
//            int bufsize,
//            int[] length,
//            int lengthOffset,
//            byte[] source,
//            int sourceOffset
//    ) {
//    }

    // c function void getShaderSource ( gLuint shader, gLsizei bufsize, gLsizei *length, char *source )

    /**
     * @hide method is broken, but used to be public (b/6006380)
     */
//    public void getShaderSource(
//            int shader,
//            int bufsize,
//            java.nio.IntBuffer length,
//            byte source
//    ) {
//    }

    // c function void getShaderSource ( gLuint shader, gLsizei bufsize, gLsizei *length, char *source )

    public String getShaderSource(
            V8Object shader
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return GLES20.glGetShaderSource(glObjects.getId(shader));
        } else throw new RuntimeException("minimal supported version of android is 4.2");
    }
    // c function const gLubyte * getString ( gLenum name )

//    public String getString(
//            int name
//    ) {
//        return "";
//    }


    // c function void getTexParameterfv ( gLenum target, gLenum pname, gLfloat *params )

    public float getTexParameter(
            int target,
            int pname
    ) {
        float[] params = new float[1];
        GLES20.glGetTexParameterfv(target,pname,params,0);
        return params[0];
    }

    // c function void getTexParameterfv ( gLenum target, gLenum pname, gLfloat *params )

//    public void getTexParameterfv(
//            int target,
//            int pname,
//            java.nio.FloatBuffer params
//    ) {
//    }

    // c function void getTexParameteriv ( gLenum target, gLenum pname, gLint *params )

//    public void getTexParameteriv(
//            int target,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getTexParameteriv ( gLenum target, gLenum pname, gLint *params )

//    public void getTexParameteriv(
//            int target,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void getUniformfv ( gLuint program, gLint location, gLfloat *params )

    public float getUniformfv(
            V8Object program,
            V8Object location
    ) {
        float[] params = new float[1];
        GLES20.glGetUniformfv(glObjects.getId(program),glObjects.getId(location),params,0);
        return params[0];
    }

    // c function void getUniformfv ( gLuint program, gLint location, gLfloat *params )

//    public void getUniformfv(
//            int program,
//            int location,
//            java.nio.FloatBuffer params
//    ) {
//    }

    // c function void getUniformiv ( gLuint program, gLint location, gLint *params )

//    public void getUniformiv(
//            int program,
//            int location,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getUniformiv ( gLuint program, gLint location, gLint *params )

//    public void getUniformiv(
//            int program,
//            int location,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function gLint getUniformLocation ( gLuint program, const char *name )

    public V8Object getUniformLocation(
            V8Object program,
            String name
    ) {
        return glObjects.create(GLES20.glGetUniformLocation(glObjects.getId(program),name));
    }

    // c function void getVertexAttribfv ( gLuint index.js, gLenum pname, gLfloat *params )

    public float getVertexAttrib(
            int index,
            int pname
    ) {
        float[] params = new float[1];
        GLES20.glGetVertexAttribfv(index,pname,params,0);
        return params[0];
    }

    // c function void getVertexAttribfv ( gLuint index.js, gLenum pname, gLfloat *params )

//    public void getVertexAttribfv(
//            int index.js,
//            int pname,
//            java.nio.FloatBuffer params
//    ) {
//    }

    // c function void getVertexAttribiv ( gLuint index.js, gLenum pname, gLint *params )

//    public void getVertexAttribiv(
//            int index.js,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void getVertexAttribiv ( gLuint index.js, gLenum pname, gLint *params )

//    public void getVertexAttribiv(
//            int index.js,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }

    // c function void hint ( gLenum target, gLenum mode )

    public void hint(
            int target,
            int mode
    ) {
        GLES20.glHint(target,mode);
    }

    // c function gLboolean isBuffer ( gLuint buffer )

    public boolean isBuffer(
            V8Object buffer
    ) {
        return GLES20.glIsBuffer(glObjects.getId(buffer));
    }

    // c function gLboolean isEnabled ( gLenum cap )

    public boolean isEnabled(
            int cap
    ) {
        return GLES20.glIsEnabled(cap);
    }

    // c function gLboolean isFramebuffer ( gLuint framebuffer )

    public boolean isFramebuffer(
            V8Object framebuffer
    ) {
        return GLES20.glIsFramebuffer(glObjects.getId(framebuffer));
    }

    // c function gLboolean isProgram ( gLuint program )

    public boolean isProgram(
            V8Object program
    ) {
        return GLES20.glIsProgram(glObjects.getId(program));
    }

    // c function gLboolean isRenderbuffer ( gLuint renderbuffer )

    public boolean isRenderbuffer(
            V8Object renderbuffer
    ) {
        return GLES20.glIsRenderbuffer(glObjects.getId(renderbuffer));
    }

    // c function gLboolean isShader ( gLuint shader )

    public boolean isShader(
            V8Object shader
    ) {
        return GLES20.glIsShader(glObjects.getId(shader));
    }

    // c function gLboolean isTexture ( gLuint texture )

    public boolean isTexture(
            V8Object texture
    ) {
        return GLES20.glIsTexture(glObjects.getId(texture));
    }

    // c function void lineWidth ( gLfloat width )

    public void lineWidth(
            float width
    ) {
        GLES20.glLineWidth(width);
    }

    // c function void linkProgram ( gLuint program )

    public void linkProgram(
            V8Object program
    ) {
        GLES20.glLinkProgram(glObjects.getId(program));
    }

    // c function void pixelStorei ( gLenum pname, gLint param )

    public void pixelStorei(
            int pname,
            int param
    ) {
        if (pname==UNPACK_PREMULTIPLY_ALPHA_WEBGL) return; //todo
        GLES20.glPixelStorei(pname,param);
    }

    // c function void polygonOffset ( gLfloat factor, gLfloat units )

    public void polygonOffset(
            float factor,
            float units
    ) {
        GLES20.glPolygonOffset(factor,units);
    }

    // c function void readPixels ( gLint x, gLint y, gLsizei width, gLsizei height, gLenum format, gLenum type, gLvoid *pixels )

    public void readPixels(
            int x,
            int y,
            int width,
            int height,
            int format,
            int type,
            V8TypedArray pixels
    ) {
        IntBuffer ib = IntBuffer.allocate(width * height);
        GLES20.glReadPixels(x,y,width,height,format,type,ib);
        for (int i = 0; i < ib.array().length; i++) {
            //pixels[i] = ib.get(i);
            // todo
        }
    }

    public int getShaderParameter(V8Object shader, int param){
        int[] params = new int[1];
        GLES20.glGetShaderiv(glObjects.getId(shader), param, params, 0);
        return params[0];
    }

    public int getProgramParameter(V8Object program, int param){
        int[] params = new int[1];
        GLES20.glGetProgramiv(glObjects.getId(program), param, params, 0);
        return params[0];
    }

    public V8Object createRenderbuffer(){
        int[] params = new int[1];
        GLES20.glGenRenderbuffers(1,params,0);
        return glObjects.create(params[0]);
    }

    public V8Object createFramebuffer(){
        int[] params = new int[1];
        GLES20.glGenFramebuffers(1,params,0);
        return glObjects.create(params[0]);
    }

    public V8Object createBuffer(){
        int[] params = new int[1];
        GLES20.glGenBuffers(1,params,0);
        return glObjects.create(params[0]);
    }

    // c function void releaseShaderCompiler ( void )

//    public void releaseShaderCompiler(
//    ) {
//    }

    // c function void renderbufferStorage ( gLenum target, gLenum internalformat, gLsizei width, gLsizei height )

    public void renderbufferStorage(
            int target,
            int internalformat,
            int width,
            int height
    ) {
        GLES20.glRenderbufferStorage(target,internalformat,width,height);
    }

    // c function void sampleCoverage ( gLclampf value, gLboolean invert )

    public void sampleCoverage(
            float value,
            boolean invert
    ) {
        GLES20.glSampleCoverage(value,invert);
    }

    // c function void scissor ( gLint x, gLint y, gLsizei width, gLsizei height )

    public void scissor(
            int x,
            int y,
            int width,
            int height
    ) {
        GLES20.glScissor(x,y,width,height);
    }

    // c function void shaderBinary ( gLsizei n, const gLuint *shaders, gLenum binaryformat, const gLvoid *binary, gLsizei length )

//    public void shaderBinary(
//            int n,
//            int[] shaders,
//            int offset,
//            int binaryformat,
//            java.nio.Buffer binary,
//            int length
//    ) {
//    }

    // c function void shaderBinary ( gLsizei n, const gLuint *shaders, gLenum binaryformat, const gLvoid *binary, gLsizei length )

//    public void shaderBinary(
//            int n,
//            java.nio.IntBuffer shaders,
//            int binaryformat,
//            java.nio.Buffer binary,
//            int length
//    ) {
//    }

    // c function void shaderSource ( gLuint shader, gLsizei count, const gLchar ** String, const gLint* length )

    public void shaderSource(
            V8Object shader,
            String source
    ) {
        GLES20.glShaderSource(glObjects.getId(shader),source);
    }
    // c function void stencilFunc ( gLenum func, gLint ref, gLuint mask )

    public void stencilFunc(
            int func,
            int ref,
            int mask
    ) {
        GLES20.glStencilFunc(func,ref,mask);
    }

    // c function void stencilFuncSeparate ( gLenum face, gLenum func, gLint ref, gLuint mask )

    public void stencilFuncSeparate(
            int face,
            int func,
            int ref,
            int mask
    ) {
        GLES20.glStencilFuncSeparate(face,func,ref,mask);
    }

    // c function void stencilMask ( gLuint mask )

    public void stencilMask(
            int mask
    ) {
        GLES20.glStencilMask(mask);
    }

    // c function void stencilMaskSeparate ( gLenum face, gLuint mask )

    public void stencilMaskSeparate(
            int face,
            int mask
    ) {
        GLES20.glStencilMaskSeparate(face,mask);
    }

    // c function void stencilOp ( gLenum fail, gLenum zfail, gLenum zpass )

    public void stencilOp(
            int fail,
            int zfail,
            int zpass
    ) {
        GLES20.glStencilOp(fail,zfail,zpass);
    }

    // c function void stencilOpSeparate ( gLenum face, gLenum fail, gLenum zfail, gLenum zpass )

    public void stencilOpSeparate(
            int face,
            int fail,
            int zfail,
            int zpass
    ) {
        GLES20.glStencilOpSeparate(face,fail,zfail,zpass);
    }

    // c function void texImage2D ( gLenum target, gLint level, gLint internalformat, gLsizei width, gLsizei height, gLint border, gLenum format, gLenum type, const gLvoid *pixels )

    public void texImage2D_9(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int border,
            int format,
            int type,
            V8TypedArray data
    ) {
        if (data==null) {
            GLES20.glTexImage2D(target,level,internalFormat,width,height,border,format,type,null);
        }
        else GLES20.glTexImage2D(target,level,internalFormat,width,height,border,format,type,data.getByteBuffer());
    }

    public void texImage2D_6(
            int target,
            int level,
            int internalFormat,
            int format,
            int type,
            V8Object source
    ){
        GLUtils.texImage2D(target,level,files.getCachedBitmap(source),0);
    }


    // c function void texSubImage2D ( gLenum target, gLint level, gLint xoffset, gLint yoffset, gLsizei width, gLsizei height, gLenum format, gLenum type, const gLvoid *pixels )

    // gl.texSubImage2D(gl.TEXTURE_2D, 0, 0, 0, this.size.width, this.size.height, gl.RGBA, gl.UNSIGNED_BYTE, this._data);
    public void texSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            V8TypedArray buffer
    ) {
        GLES20.glTexSubImage2D(target,level,xoffset,yoffset,width,height,format,type,buffer.getByteBuffer());
    }

    // c function void texParameterf ( gLenum target, gLenum pname, gLfloat param )

    public void texParameterf(
            int target,
            int pname,
            float param
    ) {
        GLES20.glTexParameterf(target,pname,param);
    }

    public void viewport(int x,int y,int w,int h) {
        GLES20.glViewport(x,y,w,h);
    }

    // c function void texParameterfv ( gLenum target, gLenum pname, const gLfloat *params )

//    public void texParameterfv(
//            int target,
//            int pname,
//            float[] params,
//            int offset
//    ) {
//    }

    // c function void texParameterfv ( gLenum target, gLenum pname, const gLfloat *params )

//    public void texParameterfv(
//            int target,
//            int pname,
//            java.nio.FloatBuffer params
//    ) {
//    }

    // c function void texParameteri ( gLenum target, gLenum pname, gLint param )

    public void texParameteri(
            int target,
            int pname,
            int param
    ) {
        GLES20.glTexParameteri(target,pname,param);
    }

    // c function void texParameteriv ( gLenum target, gLenum pname, const gLint *params )

//    public void texParameteriv(
//            int target,
//            int pname,
//            int[] params,
//            int offset
//    ) {
//    }

    // c function void texParameteriv ( gLenum target, gLenum pname, const gLint *params )

//    public void texParameteriv(
//            int target,
//            int pname,
//            java.nio.IntBuffer params
//    ) {
//    }



    // c function void uniform1f ( gLint location, gLfloat x )

    public void uniform1f(
            V8Object location,
            double x
    ) {
        GLES20.glUniform1f(glObjects.getId(location),(float) x);
    }

    // c function void uniform1fv ( gLint location, gLsizei count, const gLfloat *v )

//    public void uniform1fv(
//            int location,
//            int count,
//            float[] v,
//            int offset
//    ) {
//    }

    // c function void uniform1fv ( gLint location, gLsizei count, const gLfloat *v )

    public void uniform1fv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform1fv(glObjects.getId(location),v.length(),v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniform1i ( gLint location, gLint x )

    public void uniform1i(
            V8Object location,
            int x
    ) {
        GLES20.glUniform1i(glObjects.getId(location),x);
    }

    // c function void uniform1iv ( gLint location, gLsizei count, const gLint *v )

//    public void uniform1iv(
//            int location,
//            int count,
//            int[] v,
//            int offset
//    ) {
//    }

    // c function void uniform1iv ( gLint location, gLsizei count, const gLint *v )

    public void uniform1iv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform1iv(glObjects.getId(location),v.length(),v.getByteBuffer().asIntBuffer());
    }

    // c function void uniform2f ( gLint location, gLfloat x, gLfloat y )

    public void uniform2f(
            V8Object location,
            double x,
            double y
    ) {
        GLES20.glUniform2f(glObjects.getId(location),(float) x,(float) y);
    }

    // c function void uniform2fv ( gLint location, gLsizei count, const gLfloat *v )

//    public void uniform2fv(
//            int location,
//            int count,
//            float[] v,
//            int offset
//    ) {
//    }

    // c function void uniform2fv ( gLint location, gLsizei count, const gLfloat *v )

    public void uniform2fv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform2fv(glObjects.getId(location),v.length(),v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniform2i ( gLint location, gLint x, gLint y )

    public void uniform2i(
            V8Object location,
            int x,
            int y
    ) {
        GLES20.glUniform2i(glObjects.getId(location),x,y);
    }

    // c function void uniform2iv ( gLint location, gLsizei count, const gLint *v )

//    public void uniform2iv(
//            int location,
//            int count,
//            int[] v,
//            int offset
//    ) {
//    }

    // c function void uniform2iv ( gLint location, gLsizei count, const gLint *v )

    public void uniform2iv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform2iv(glObjects.getId(location),v.length(),v.getByteBuffer().asIntBuffer());
    }

    // c function void uniform3f ( gLint location, gLfloat x, gLfloat y, gLfloat z )

    public void uniform3f(
            V8Object location,
            double x,
            double y,
            double z
    ) {
        GLES20.glUniform3f(glObjects.getId(location),(float)x,(float) y,(float) z);
    }

    // c function void uniform3fv ( gLint location, gLsizei count, const gLfloat *v )

//    public void uniform3fv(
//            int location,
//            int count,
//            float[] v,
//            int offset
//    ) {
//    }

    // c function void uniform3fv ( gLint location, gLsizei count, const gLfloat *v )

    public void uniform3fv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform3fv(glObjects.getId(location),v.length(),v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniform3i ( gLint location, gLint x, gLint y, gLint z )

    public void uniform3i(
            V8Object location,
            int x,
            int y,
            int z
    ) {
        GLES20.glUniform3i(glObjects.getId(location),x,y,z);
    }

    // c function void uniform3iv ( gLint location, gLsizei count, const gLint *v )

//    public void uniform3iv(
//            int location,
//            int count,
//            int[] v,
//            int offset
//    ) {
//    }

    // c function void uniform3iv ( gLint location, gLsizei count, const gLint *v )

    public void uniform3iv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform3iv(glObjects.getId(location),v.length(),v.getByteBuffer().asIntBuffer());
    }

    // c function void uniform4f ( gLint location, gLfloat x, gLfloat y, gLfloat z, gLfloat w )

    public void uniform4f(
            V8Object location,
            double x,
            double y,
            double z,
            double w
    ) {
        GLES20.glUniform4f(glObjects.getId(location),(float) x,(float) y,(float) z,(float) w);
    }

    // c function void uniform4fv ( gLint location, gLsizei count, const gLfloat *v )

//    public void uniform4fv(
//            int location,
//            int count,
//            float[] v,
//            int offset
//    ) {
//    }

    // c function void uniform4fv ( gLint location, gLsizei count, const gLfloat *v )

    public void uniform4fv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform4fv(glObjects.getId(location),v.length(),v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniform4i ( gLint location, gLint x, gLint y, gLint z, gLint w )

    public void uniform4i(
            V8Object location,
            int x,
            int y,
            int z,
            int w
    ) {
        GLES20.glUniform4i(glObjects.getId(location),x,y,w,z);
    }

    // c function void uniform4iv ( gLint location, gLsizei count, const gLint *v )

//    public void uniform4iv(
//            int location,
//            int count,
//            int[] v,
//            int offset
//    ) {
//    }

    // c function void uniform4iv ( gLint location, gLsizei count, const gLint *v )

    public void uniform4iv(
            V8Object location,
            V8TypedArray v
    ) {
        GLES20.glUniform4iv(glObjects.getId(location),v.length(),v.getByteBuffer().asIntBuffer());
    }

    // c function void uniformMatrix2fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

//    public void uniformMatrix2fv(
//            int location,
//            int count,
//            boolean transpose,
//            float[] value,
//            int offset
//    ) {
//    }

    // c function void uniformMatrix2fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

    public void uniformMatrix2fv(
            V8Object location,
            boolean transpose,
            V8TypedArray v
    ) {
        GLES20.glUniformMatrix2fv(glObjects.getId(location),1,transpose,v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniformMatrix3fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

//    public void uniformMatrix3fv(
//            int location,
//            int count,
//            boolean transpose,
//            float[] value,
//            int offset
//    ) {
//    }

    // c function void uniformMatrix3fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

    public void uniformMatrix3fv(
            V8Object location,
            boolean transpose,
            V8TypedArray v
    ) {
        GLES20.glUniformMatrix3fv(glObjects.getId(location),1,transpose,v.getByteBuffer().asFloatBuffer());
    }

    // c function void uniformMatrix4fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

//    public void uniformMatrix4fv(
//            int location,
//            int count,
//            boolean transpose,
//            float[] value,
//            int offset
//    ) {
//    }

    // c function void uniformMatrix4fv ( gLint location, gLsizei count, gLboolean transpose, const gLfloat *value )

    public void uniformMatrix4fv(
            V8Object location,
            boolean transpose,
            V8TypedArray v
    ) {
        GLES20.glUniformMatrix4fv(glObjects.getId(location),1,transpose,v.getByteBuffer().asFloatBuffer());
    }

//    public void uniformMatrix4fv(
//            V8Object location,
//            int transpose,
//            V8TypedArray v
//    ) {
//        uniformMatrix4fv(location,transpose==1,v);
//    }

    // c function void useProgram ( gLuint program )

    public void useProgram(
            V8Object program
    ) {
        if (program==null) GLES20.glUseProgram(0);
        else GLES20.glUseProgram(glObjects.getId(program));
    }

    // c function void validateProgram ( gLuint program )

    public void validateProgram(
            V8Object program
    ) {
        GLES20.glValidateProgram(glObjects.getId(program));
    }

    // c function void vertexAttrib1f ( gLuint indx, gLfloat x )

    public void vertexAttrib1f(
            int indx,
            float x
    ) {
        GLES20.glVertexAttrib1f(indx,x);
    }

    // c function void vertexAttrib1fv ( gLuint indx, const gLfloat *values )

//    public void vertexAttrib1fv(
//            int indx,
//            float[] values,
//            int offset
//    ) {
//    }

    // c function void vertexAttrib1fv ( gLuint indx, const gLfloat *values )

    public void vertexAttrib1fv(
            int indx,
            V8TypedArray values
    ) {
        GLES20.glVertexAttrib1fv(indx,values.getByteBuffer().asFloatBuffer());
    }

    // c function void vertexAttrib2f ( gLuint indx, gLfloat x, gLfloat y )

    public void vertexAttrib2f(
            int indx,
            float x,
            float y
    ) {
        GLES20.glVertexAttrib2f(indx,x,y);
    }

    // c function void vertexAttrib2fv ( gLuint indx, const gLfloat *values )

//    public void vertexAttrib2fv(
//            int indx,
//            float[] values,
//            int offset
//    ) {
//    }

    // c function void vertexAttrib2fv ( gLuint indx, const gLfloat *values )

    public void vertexAttrib2fv(
            int indx,
            V8TypedArray values
    ) {
        GLES20.glVertexAttrib2fv(indx,values.getByteBuffer().asFloatBuffer());
    }

    // c function void vertexAttrib3f ( gLuint indx, gLfloat x, gLfloat y, gLfloat z )

    public void vertexAttrib3f(
            int indx,
            float x,
            float y,
            float z
    ) {
        GLES20.glVertexAttrib3f(indx,x,y,z);
    }

    // c function void vertexAttrib3fv ( gLuint indx, const gLfloat *values )

//    public void vertexAttrib3fv(
//            int indx,
//            float[] values,
//            int offset
//    ) {
//    }

    // c function void vertexAttrib3fv ( gLuint indx, const gLfloat *values )

    public void vertexAttrib3fv(
            int indx,
            V8TypedArray values
    ) {
        GLES20.glVertexAttrib3fv(indx,values.getByteBuffer().asFloatBuffer());
    }

    // c function void vertexAttrib4f ( gLuint indx, gLfloat x, gLfloat y, gLfloat z, gLfloat w )

    public void vertexAttrib4f(
            int indx,
            float x,
            float y,
            float z,
            float w
    ) {
        GLES20.glVertexAttrib4f(indx,x,y,z,w);
    }

    // c function void vertexAttrib4fv ( gLuint indx, const gLfloat *values )

//    public void vertexAttrib4fv(
//            int indx,
//            float[] values,
//            int offset
//    ) {
//    }

    // c function void vertexAttrib4fv ( gLuint indx, const gLfloat *values )

    public void vertexAttrib4fv(
            int indx,
            V8TypedArray values
    ) {
        GLES20.glVertexAttrib4fv(indx,values.getByteBuffer().asFloatBuffer());
    }

    // c function void vertexAttribPointer ( gLuint indx, gLint size, gLenum type, gLboolean normalized, gLsizei stride, gLint offset )

    public void vertexAttribPointer(
            int indx,
            int size,
            int type,
            boolean normalized,
            int stride,
            int offset
    ) {
        GLES20.glVertexAttribPointer(indx,size,type,normalized,stride,offset);
    }

}
