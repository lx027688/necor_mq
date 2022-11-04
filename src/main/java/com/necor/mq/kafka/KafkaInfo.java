package com.necor.mq.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller - kafka 简单模式
 *
 * @author necor
 * @version 1.0
 * @Time 2022年10月31日 15:35:20
 */
@RestController("KafkaInfoController")
@RequestMapping("/kafka/info")
public class KafkaInfo {

	@Autowired
	private ConsumerFactory<Long, String> consumerFactory;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	@Autowired
//	private AdminClient kafkaAdminClient;


//	/**
//	 * 获取分组下的表述信息
//	 *
//	 * @param topics
//	 * @return
//	 * date 2021-01-22
//	 **/
//	@GetMapping(value="/view")
//	public ResponseDto view(HttpServletRequest request,String[] topics){
//		long[] describe = new long[3];
//		Consumer<Long, String> consumer = consumerFactory.createConsumer();
//		for (String topic : topics) {
//			List<PartitionInfo> partitionInfos = kafkaTemplate.partitionsFor(topic);
//			List<TopicPartition> tp = new ArrayList<>();
//			partitionInfos.forEach(str -> {
//				TopicPartition topicPartition = new TopicPartition(topic, str.partition());
//				tp.add(topicPartition);
//				long logEndOffset = consumer.endOffsets(tp).get(topicPartition);
//				consumer.assign(tp);
//				consumer.position(topicPartition);
//				long currentOffset = consumer.position(topicPartition);
//				describe[0] += currentOffset;
//				describe[1] += logEndOffset;
//				describe[2] = describe[1] - describe[0];
//			});
//		}
//		Logs.info(Arrays.toString(describe));
//		return ResponseDto.success("操作成功").data(describe);
//	}
}