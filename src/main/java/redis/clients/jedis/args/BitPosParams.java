package redis.clients.jedis.args;

import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.CommandArguments;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.params.IParams;

public class BitPosParams implements IParams {
  private List<byte[]> params = new ArrayList<>();

  protected BitPosParams() {
  }

  public BitPosParams(long start) {
    params.add(Protocol.toByteArray(start));
  }

  public BitPosParams(long start, long end) {
    this(start);

    params.add(Protocol.toByteArray(end));
  }

  @Override
  public void addParams(CommandArguments args) {
    for (byte[] param : params) {
      args.addObject(param);
    }
  }
}