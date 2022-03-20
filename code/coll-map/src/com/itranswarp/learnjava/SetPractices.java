package com.itranswarp.learnjava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author wxz
 */
public class SetPractices {
	public static void main(String[] args) {
		/*
		 * 在聊天软件中， 发送方发送消息时， 
		 * 遇到网络超时后就会自动重发 ，
		 * 因此， 接收方可能会收到重复的消息，
		 * 在显示给用户看的时候，
		 * 需要首先去重。
		 * 请练习使用Set去除重复的消息：
		 */
		List<Message> received = List.of(	new Message(1, "Hello!"), 
									new Message(2, "发工资了吗？"),
									new Message(2, "发工资了吗？"),
									new Message(3, "去哪吃饭？"),
									new Message(3, "去哪吃饭？"), 
									new Message(4, "Bye"));
		List<Message> displayMessages = process(received);
		for (Message message : displayMessages) {
			System.out.println(message.text);
		}
	}

    
	static List<Message> process(List<Message> received) {
		        // TODO: 按sequence去除重复消息
//    	使用set获取重复的SequenceSet，并返回重复的list index

//    			Set<Integer> SequenceSet = new HashSet<>();
//    			String mark = "";
//    			for (Message mes : received) {
//    				if (SequenceSet.add(mes.sequence)==false) {
//    					mark +=mes.sequence+",";
//    				}					
//				}
//    			
//    			received = new ArrayList<Message>(received);
//    			String[] delIndex = mark.split(",");
//    			for (String i : delIndex) {
//    				System.out.println(i);
//    				received.remove(Integer.parseInt(i));
//				}
				List<Message> receivedCopy = new ArrayList<Message>();
//				received = new ArrayList<Message>(received);
				Set<Integer> SequenceSet = new HashSet<>();
    			for (Message message : received) {
    				if(SequenceSet.add(message.sequence)) {
    					receivedCopy.add(message);
    				}
				}
    			received = receivedCopy;
		        return received;
    }
}


class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;


}
}