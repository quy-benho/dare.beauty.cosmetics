package dare.beauty.cosmetics.util;

import java.util.UUID;

public class AppUtil {


	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString().replace("-", "");
		return uuidAsString;
	}
}
