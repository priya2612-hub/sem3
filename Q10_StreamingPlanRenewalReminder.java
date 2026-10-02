import java.util.*;
import java.time.LocalDate;

abstract class StreamingPlan {
    LocalDate startDate;

    StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();

    abstract String getPlan();
}

