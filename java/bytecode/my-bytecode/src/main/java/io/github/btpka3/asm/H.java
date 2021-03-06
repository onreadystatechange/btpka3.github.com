package io.github.btpka3.asm;

import org.apache.commons.io.*;
import org.objectweb.asm.*;

import java.io.*;

/**
 * 该文件是从 Astah_professional 7.2.0 ( RELEASE at 2017/09/27) 中 获取。
 * 主要是用来判断评估版的过期时间。
 * 通过UI界面提示消息，定位到 "license_evaluation_term.message" 这个消息代码，
 * 根据代码找到提示的位置（多个，该文件是一个）
 * 分析判断逻辑。
 *
 * $HOME/.astah/professional/.ael 是安装的时间，比如： "2017/09/30"，但是经过了 gzip 压缩。
 * h.class#g(string) : Line 74 是用来获取过期时间的，故可以通过修改这里的代码来增加评估版的时长。
 *
 * PS: 第一次使用 Mac 系统，默认使用了不区分大小写的文件系统，
 * 造成 astah-pro.jar 解压有问题——N多重名的文件。
 *
 */
public class H implements Opcodes {

    public static void main(String[] args) throws Exception {

        String dirPath = ".tmp";
        String filePath = dirPath + "/h.class";

        IOUtils.write(dump(), new FileOutputStream(filePath));
        System.out.println(111);
    }
    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "JP/co/esm/caddies/jomt/license/h", null, "java/lang/Object", null);

        {
            fv = cw.visitField(ACC_PUBLIC + ACC_STATIC, "a", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_STATIC, "b", "Z", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "c", "Lorg/slf4j/Logger;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // public static boolean a()
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "a", "()Z", null, null);
            mv.visitCode();
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "(Ljava/lang/String;)Z", false);
            Label l0 = new Label();
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "d", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/jsystem/c", "q", "Z");
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "Z");
            Label l2 = new Label();
            mv.visitJumpInsn(IFNE, l2);
            mv.visitLdcInsn("app");
            mv.visitLdcInsn("without_any_license");
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jview/eO", "d", "(Ljava/lang/String;Ljava/lang/String;)V", false);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(ICONST_1);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "Z");
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/jsystem/c", "q", "Z");
            Label l3 = new Label();
            mv.visitJumpInsn(IFNE, l3);
            mv.visitInsn(ICONST_1);
            Label l4 = new Label();
            mv.visitJumpInsn(GOTO, l4);
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(ICONST_0);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{Opcodes.INTEGER});
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "()Ljava/lang/String;", false);
            mv.visitVarInsn(ASTORE, 0);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "Ljava/lang/String;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            mv.visitInsn(POP);
            mv.visitInsn(ICONST_1);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/jsystem/c", "p", "Z");
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "(Ljava/lang/String;)Ljava/lang/String;", false);
            mv.visitInsn(AASTORE);
            mv.visitLdcInsn("app");
            mv.visitLdcInsn("license_evaluation_term.message");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jview/eO", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", false);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/p", "c", "()LJP/co/esm/caddies/jomt/license/p;", false);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jsystem/j", "d", "()Ljava/lang/String;", false);
            mv.visitLdcInsn("P");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
            Label l5 = new Label();
            mv.visitJumpInsn(IFEQ, l5);
            mv.visitLdcInsn("astah_professional");
            Label l6 = new Label();
            mv.visitJumpInsn(GOTO, l6);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"JP/co/esm/caddies/jomt/license/p"});
            mv.visitLdcInsn("astah_UML");
            mv.visitLabel(l6);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 2, new Object[]{"JP/co/esm/caddies/jomt/license/p", "java/lang/String"});
            mv.visitLdcInsn("USER_TYPE");
            mv.visitLdcInsn("Evaluation");
            mv.visitMethodInsn(INVOKEVIRTUAL, "JP/co/esm/caddies/jomt/license/p", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", false);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(4, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "b", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitLdcInsn("yyyy/MM/dd");
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jutil/JomtUtilities", "getDateString", "(Ljava/lang/String;)Ljava/lang/String;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "f", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(ICONST_4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_5);
            mv.visitIntInsn(BIPUSH, 7);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(ISUB);
            mv.visitVarInsn(ISTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitIntInsn(BIPUSH, 8);
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(ISTORE, 3);
            mv.visitTypeInsn(NEW, "java/util/GregorianCalendar");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/GregorianCalendar", "<init>", "(III)V", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "c", "()Ljava/util/GregorianCalendar;", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "f", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }

        // private static GregorianCalendar g(String var0)
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "g", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(ICONST_4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_5);
            mv.visitIntInsn(BIPUSH, 7);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(ISUB);
            mv.visitVarInsn(ISTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitIntInsn(BIPUSH, 8);
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(ISTORE, 3);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "c", "()Ljava/util/GregorianCalendar;", false);
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "set", "(III)V", false);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitInsn(ICONST_5);
            //mv.visitIntInsn(BIPUSH, 20);
            mv.visitIntInsn(BIPUSH, 3650);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "add", "(II)V", false);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 5);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "a", "(Ljava/lang/String;)Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "g", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", false);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "getTime", "()Ljava/util/Date;", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitInsn(ICONST_1);
            mv.visitMethodInsn(INVOKESTATIC, "java/text/DateFormat", "getDateInstance", "(I)Ljava/text/DateFormat;", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/text/DateFormat", "format", "(Ljava/util/Date;)Ljava/lang/String;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(2, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "b", "(Ljava/lang/String;)Z", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "java/io/File");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/File", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/File", "exists", "()Z", false);
            Label l0 = new Label();
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "c", "(Ljava/lang/String;)Ljava/lang/String;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
            mv.visitLdcInsn("");
            mv.visitVarInsn(ASTORE, 1);
            mv.visitInsn(ACONST_NULL);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitLabel(l0);
            mv.visitTypeInsn(NEW, "java/util/zip/GZIPInputStream");
            mv.visitInsn(DUP);
            mv.visitTypeInsn(NEW, "java/io/FileInputStream");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/FileInputStream", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/zip/GZIPInputStream", "<init>", "(Ljava/io/InputStream;)V", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitTypeInsn(NEW, "java/io/InputStreamReader");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitLdcInsn("UTF-8");
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/InputStreamReader", "<init>", "(Ljava/io/InputStream;Ljava/lang/String;)V", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitTypeInsn(NEW, "java/io/BufferedReader");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/BufferedReader", "<init>", "(Ljava/io/Reader;)V", false);
            mv.visitVarInsn(ASTORE, 4);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_FULL, 5, new Object[]{Opcodes.TOP, "java/lang/String", Opcodes.TOP, Opcodes.TOP, "java/io/BufferedReader"}, 0, new Object[]{});
            mv.visitVarInsn(ALOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedReader", "readLine", "()Ljava/lang/String;", false);
            mv.visitInsn(DUP);
            mv.visitVarInsn(ASTORE, 5);
            Label l4 = new Label();
            mv.visitJumpInsn(IFNULL, l4);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "length", "()I", false);
            mv.visitJumpInsn(IFLE, l3);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitJumpInsn(GOTO, l3);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedReader", "close", "()V", false);
            mv.visitLabel(l1);
            Label l5 = new Label();
            mv.visitJumpInsn(GOTO, l5);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 1, new Object[]{"java/lang/Exception"});
            mv.visitVarInsn(ASTORE, 3);
            mv.visitFieldInsn(GETSTATIC, "JP/co/esm/caddies/jomt/license/h", "c", "Lorg/slf4j/Logger;");
            mv.visitLdcInsn("error has occurred.");
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/slf4j/Logger", "error", "(Ljava/lang/String;Ljava/lang/Throwable;)V", true);
            mv.visitInsn(ACONST_NULL);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{Opcodes.TOP, "java/lang/String"}, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/io/IOException");
            Label l3 = new Label();
            Label l4 = new Label();
            Label l5 = new Label();
            mv.visitTryCatchBlock(l3, l4, l5, "java/lang/Throwable");
            Label l6 = new Label();
            Label l7 = new Label();
            Label l8 = new Label();
            mv.visitTryCatchBlock(l6, l7, l8, "java/io/IOException");
            Label l9 = new Label();
            mv.visitTryCatchBlock(l3, l4, l9, null);
            Label l10 = new Label();
            mv.visitTryCatchBlock(l5, l10, l9, null);
            Label l11 = new Label();
            Label l12 = new Label();
            Label l13 = new Label();
            mv.visitTryCatchBlock(l11, l12, l13, "java/io/IOException");
            Label l14 = new Label();
            mv.visitTryCatchBlock(l9, l14, l9, null);
            mv.visitInsn(ACONST_NULL);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitLabel(l3);
            mv.visitTypeInsn(NEW, "java/io/BufferedWriter");
            mv.visitInsn(DUP);
            mv.visitTypeInsn(NEW, "java/io/OutputStreamWriter");
            mv.visitInsn(DUP);
            mv.visitTypeInsn(NEW, "java/util/zip/GZIPOutputStream");
            mv.visitInsn(DUP);
            mv.visitTypeInsn(NEW, "java/io/FileOutputStream");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/zip/GZIPOutputStream", "<init>", "(Ljava/io/OutputStream;)V", false);
            mv.visitLdcInsn("UTF-8");
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/OutputStreamWriter", "<init>", "(Ljava/io/OutputStream;Ljava/lang/String;)V", false);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/BufferedWriter", "<init>", "(Ljava/io/Writer;)V", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedWriter", "write", "(Ljava/lang/String;)V", false);
            mv.visitLabel(l4);
            mv.visitVarInsn(ALOAD, 2);
            Label l15 = new Label();
            mv.visitJumpInsn(IFNULL, l15);
            mv.visitLabel(l0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedWriter", "close", "()V", false);
            mv.visitLabel(l1);
            mv.visitJumpInsn(GOTO, l15);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "getMessage", "()Ljava/lang/String;", false);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_FULL, 3, new Object[]{Opcodes.TOP, Opcodes.TOP, "java/io/BufferedWriter"}, 1, new Object[]{"java/lang/Throwable"});
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Throwable", "getMessage", "()Ljava/lang/String;", false);
            mv.visitVarInsn(ASTORE, 4);
            mv.visitLabel(l10);
            mv.visitVarInsn(ALOAD, 2);
            Label l16 = new Label();
            mv.visitJumpInsn(IFNULL, l16);
            mv.visitLabel(l6);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedWriter", "close", "()V", false);
            mv.visitLabel(l7);
            mv.visitJumpInsn(GOTO, l16);
            mv.visitLabel(l8);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 5);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "getMessage", "()Ljava/lang/String;", false);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l16);
            mv.visitFrame(Opcodes.F_FULL, 5, new Object[]{Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/String"}, 0, new Object[]{});
            mv.visitVarInsn(ALOAD, 4);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l9);
            mv.visitFrame(Opcodes.F_FULL, 3, new Object[]{Opcodes.TOP, Opcodes.TOP, "java/io/BufferedWriter"}, 1, new Object[]{"java/lang/Throwable"});
            mv.visitVarInsn(ASTORE, 6);
            mv.visitLabel(l14);
            mv.visitVarInsn(ALOAD, 2);
            Label l17 = new Label();
            mv.visitJumpInsn(IFNULL, l17);
            mv.visitLabel(l11);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/BufferedWriter", "close", "()V", false);
            mv.visitLabel(l12);
            mv.visitJumpInsn(GOTO, l17);
            mv.visitLabel(l13);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 7);
            mv.visitVarInsn(ALOAD, 7);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "getMessage", "()Ljava/lang/String;", false);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l17);
            mv.visitFrame(Opcodes.F_FULL, 7, new Object[]{Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"}, 0, new Object[]{});
            mv.visitVarInsn(ALOAD, 6);
            mv.visitInsn(ATHROW);
            mv.visitLabel(l15);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 0, new Object[]{});
            mv.visitLdcInsn("");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(9, 8);
            mv.visitEnd();
        }

        // public static void d(String var0)
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "d", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "c", "(Ljava/lang/String;)Ljava/lang/String;", false);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "e", "(Ljava/lang/String;)Z", false);
            mv.visitVarInsn(ISTORE, 2);
            mv.visitVarInsn(ILOAD, 2);
            Label l0 = new Label();
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitInsn(ICONST_1);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/jsystem/c", "p", "Z");
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/p", "c", "()LJP/co/esm/caddies/jomt/license/p;", false);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jsystem/j", "d", "()Ljava/lang/String;", false);
            mv.visitLdcInsn("P");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitLdcInsn("astah_professional");
            Label l2 = new Label();
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_FULL, 2, new Object[]{Opcodes.TOP, "java/lang/String"}, 1, new Object[]{"JP/co/esm/caddies/jomt/license/p"});
            mv.visitLdcInsn("astah_UML");
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 2, new Object[]{Opcodes.TOP, "java/lang/String"}, 2, new Object[]{"JP/co/esm/caddies/jomt/license/p", "java/lang/String"});
            mv.visitLdcInsn("USER_TYPE");
            mv.visitLdcInsn("Evaluation");
            mv.visitMethodInsn(INVOKEVIRTUAL, "JP/co/esm/caddies/jomt/license/p", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", false);
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "(Ljava/lang/String;)Ljava/lang/String;", false);
            mv.visitInsn(AASTORE);
            mv.visitLdcInsn("app");
            mv.visitLdcInsn("license_evaluation_term.message");
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jview/eO", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", false);
            Label l3 = new Label();
            mv.visitJumpInsn(GOTO, l3);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_CHOP, 2, null, 0, null);
            mv.visitInsn(ICONST_1);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/jsystem/c", "q", "Z");
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "e", "(Ljava/lang/String;)Z", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "c", "()Ljava/util/GregorianCalendar;", false);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "f", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/license/h", "g", "(Ljava/lang/String;)Ljava/util/GregorianCalendar;", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "equals", "(Ljava/lang/Object;)Z", false);
            Label l0 = new Label();
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_FULL, 4, new Object[]{Opcodes.TOP, "java/util/GregorianCalendar", "java/util/GregorianCalendar", "java/util/GregorianCalendar"}, 0, new Object[]{});
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "equals", "(Ljava/lang/Object;)Z", false);
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "before", "(Ljava/lang/Object;)Z", false);
            Label l2 = new Label();
            mv.visitJumpInsn(IFEQ, l2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/GregorianCalendar", "before", "(Ljava/lang/Object;)Z", false);
            mv.visitJumpInsn(IFEQ, l2);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 0, new Object[]{}, 0, new Object[]{});
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitMethodInsn(INVOKESTATIC, "JP/co/esm/caddies/jomt/jsystem/j", "s", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitFieldInsn(GETSTATIC, "java/io/File", "separator", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitLdcInsn(".ael");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/license/h", "a", "Ljava/lang/String;");
            mv.visitInsn(ICONST_0);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/license/h", "b", "Z");
            mv.visitLdcInsn(Type.getType("LJP/co/esm/caddies/jomt/license/h;"));
            mv.visitMethodInsn(INVOKESTATIC, "org/slf4j/LoggerFactory", "getLogger", "(Ljava/lang/Class;)Lorg/slf4j/Logger;", false);
            mv.visitFieldInsn(PUTSTATIC, "JP/co/esm/caddies/jomt/license/h", "c", "Lorg/slf4j/Logger;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
