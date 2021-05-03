package forms;

import java.util.Map;

public abstract class AbstractForm {

    public abstract Map<String, ? super Comparable> exec();
}