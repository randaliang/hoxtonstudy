package com.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author randaliang
 * @date 2022-04-01 10:15
 **/
public class ByteBuddyTest {

    public static void main(String[] args) {
//        redefine1();
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(NewObjectDTO.class).name(ObjectDTO.class.getName())
                .make().load(NewObjectDTO.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        ObjectDTO o = new ObjectDTO();
        o.setObj_source("1111");

        System.out.println(o.getObj_source());

//        new ByteBuddy()
//                .redefine(ObjectDTO.class)
//                .method(ElementMatchers.named("getObj_source"))
////                .intercept(FixedValue.value("Hello Foo Redefined"))
//                .intercept(MethodDelegation.to(NewObjectDTO.class))
//                .make()
//                .load(ObjectDTO.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
//            System.out.println(new ObjectDTO().getObj_source());

    }

    public static void redefine1(){
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(NewObjectDTO.class).name(ObjectDTO.class.getName())
                .make().load(NewObjectDTO.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println(new ObjectDTO().getObj_source());
    }
}

