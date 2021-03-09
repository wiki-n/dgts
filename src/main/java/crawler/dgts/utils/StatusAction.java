package crawler.dgts.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum StatusAction {
    ACTIVATE("activate"),
    DEACTIVATE("deactivate"),
    RESTORE("restore");

    private final String value;

    private static final Map<String, StatusAction> lookup = new HashMap();

    public static StatusAction get(String value) {
        return lookup.get(value);
    }

    static {
        Iterator var0 = EnumSet.allOf(StatusAction.class).iterator();

        while(var0.hasNext()) {
            StatusAction e = (StatusAction)var0.next();
            lookup.put(e.getValue(), e);
        }

    }
}
