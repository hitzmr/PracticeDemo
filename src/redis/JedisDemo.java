package redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisDemo {
	private Jedis jedis;
	
	public JedisDemo(){
		this.jedis = new Jedis("localhost");
		System.out.println("jedis initial success:" + jedis.ping() );
	}

	public static void main(String[] args) {
		JedisDemo jedisDemo = new JedisDemo();
		jedisDemo.opString();
		jedisDemo.opHash();
		jedisDemo.opList();
		jedisDemo.opSet();
	}
	
	public void opString(){
		jedis.set("name", "bsnpc1g");
		jedis.set("band", "1");
		jedis.dump("name");
		
		System.out.println("opString \r\n " + "name:" + jedis.get("name") + " band:" +jedis.get("band") + "\r\n");
		
	}
	
	public void opHash(){
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("语文", "Chinese");
		hash.put("数学", "Math");
		hash.put("英语", "English");
		hash.put("自然", "Nature");
		jedis.hmset("myHash", hash);

		System.out.println("opHash");
		Map<String, String> map= jedis.hgetAll("myHash");
		for(String key:map.keySet()){
			System.out.println("key:" + key + " value:" + map.get(key));
		}
		System.out.println("\r\n");
	}
	
	public void opList(){
		System.out.println("opList");
		jedis.lpush("myList", "listcolumn1", "listcolumn2", "listcolumn2", "listcolumn2", "listcolumn2");
		System.out.println(jedis.lrange("myList", 0, 5));
	}
	
	public void opSet(){
		System.out.println();
		System.out.println("opSet");
		jedis.sadd("opSet \r\n" + "mySet", "1", "2", "3", "4");
		System.out.print(jedis.spop("mySet"));
	}

}
