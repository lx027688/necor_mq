package com.necor.mq.kafka;

import com.necor.mq.common.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller - kafka 广播模式
 *
 * @author necor
 * @version 1.0
 * @Time 2022年10月31日 15:35:20
 */
@RestController("KafkaBroadcastController")
@RequestMapping("/kafka/broadcast")
public class BroadcastModel {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	/**
	* 发送消息
	* @param request
	* @param msg
	* @return
	*/
	@GetMapping(value="/send/{msg}")
	public ResponseData send(HttpServletRequest request, @PathVariable String msg){
		System.out.println(String.format("生产者发送消息: %s" , msg));
		this.template.send("broadcast", msg);
		return ResponseData.success("操作成功").data(msg);
	}

	@KafkaListener(id = "broadcastConsumer0",groupId = "broadcastGroup1",topics = "broadcast")
	public void listen(String msg) {
		System.out.println(String.format("消费者0接收到消息: %s" , msg));
	}

	@KafkaListener(id = "broadcastConsumer1",groupId = "broadcastGroup1",topics = "broadcast")
	public void listen1(String msg) {
		System.out.println(String.format("消费者1接收到消息: %s" , msg));
	}

	@KafkaListener(id = "broadcastConsumer2", groupId = "broadcastGroup2",topics = "broadcast")
	public void listen2(String msg) {
		System.out.println(String.format("消费者2接收到消息: %s" , msg));
	}

	@KafkaListener(id = "broadcastConsumer3", groupId = "broadcastGroup3",topics = "broadcast")
	public void listen3(String msg) {
		System.out.println(String.format("消费者3接收到消息: %s" , msg));
	}
}