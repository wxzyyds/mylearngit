package com.itranswarp.learnjava;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRadomTest {
	public static void main(String[] args) {
//		真随机数
		/*
		 * 实际上真正的真随机数只能通过量子力学原理来获取
		 * ，而我们想要的是一个不可预测的安全的随机数，
		 * SecureRandom就是用来创建安全的随机数的：
		 */
//		SecureRandom无法指定种子，它使用RNG（random number generator）算法。
		SecureRandom sr = new SecureRandom();
		System.out.println(sr.nextInt(100));
		SecureRandom sr1 = null;
        try {
//        	sr1 = SecureRandom.getInstance("NativePRNGNonBlocking");
            sr1 = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器,因为系统的随机数池子收集的熵不够，在等，比较慢一般出现在虚拟机或者docker环境里，实体机基本不会等
        } catch (NoSuchAlgorithmException e) {
            sr1 = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr1.nextBytes(buffer); // 用安全随机数填充buffer
        
//      boolean[] buffer = new boolean[16];
//    
//      for (int i = 0; i < buffer.length; i++) {
//      	buffer[i] =   sr1.nextBoolean(); // 用安全随机数填充buffer
//		}
        System.out.println(Arrays.toString(buffer));
	}
}

