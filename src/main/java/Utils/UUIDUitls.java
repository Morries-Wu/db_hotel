package Utils;

import java.util.UUID;

public class UUIDUitls {
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("_", "");
    }
}
