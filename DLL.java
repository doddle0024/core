ArithmeticOperations.c


#include <jni.h>
#include "ArithmeticOperations.h"

JNIEXPORT jint JNICALL Java_ArithmeticOperations_add(JNIEnv *env, jobject obj, jint
a, jint b) {
return a + b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_subtract(JNIEnv *env, jobject obj,
jint a, jint b) {
return a - b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_multiply(JNIEnv *env, jobject obj,
jint a, jint b) {
return a * b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_divide(JNIEnv *env, jobject obj,
jint a, jint b) {
if (b == 0) {
return 0; // Handle division by zero
}
return a / b;
}

ArithmeticOperations.java

public class ArithmeticOperations
{
public native int add(int a, int b);

public native int subtract(int a, int b);
public native int multiply(int a, int b);
public native int divide(int a, int b);

static
{
System.loadLibrary("ArithmeticOperations");
}

public static void main(String[] args)
{
ArithmeticOperations ops = new ArithmeticOperations();
int a = 20, b = 10;
System.out.println("Addition: " +ops.add(a,b));
System.out.println("Subtraction: " +ops.subtract(a,b));
System.out.println("Multiplication: " +ops.multiply(a,b));
System.out.println("Division: " +ops.divide(a,b));
}
}
