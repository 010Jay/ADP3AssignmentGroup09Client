package za.ac.cput.generic;

import java.util.UUID;

public class GenericHelper {

    public static int generateUniqueIntId() {
        UUID generateId = UUID.randomUUID();

        String uniqueIntId = "" + generateId;
        int idHash = uniqueIntId.hashCode();
        String filterId = "" + idHash;
        uniqueIntId = filterId.replaceAll("-", "");
        return Integer.parseInt(uniqueIntId);
    }

}
