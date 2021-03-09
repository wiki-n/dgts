package crawler.dgts.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum ECurrency {

    VND("Đồng Việt Nam"),
    USD("Đồng Đô La Mỹ");

    private final String value;

    private static final Map<String, ECurrency> lookup = new HashMap();

    public static ECurrency get(String value) {
        return lookup.get(value);
    }

    static {
        Iterator var0 = EnumSet.allOf(ECurrency.class).iterator();

        while(var0.hasNext()) {
            ECurrency e = (ECurrency)var0.next();
            lookup.put(e.getValue(), e);
        }

    }
}
