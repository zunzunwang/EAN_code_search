package org.zzw.testEAN;

import java.util.ArrayList;
import java.util.List;
 
class PrintList {
	private List list;
    private static int i;
 
    public PrintList(List list) {
        this.list = list;
    }
 
    public synchronized String getElement() {
        if (i >= list.size())//读完的话就返回null，暂时决定，如果前面的有null的话，可不会打印null
            return null;
        String str = (String) list.get(i);
        i++;
        return str;
    }
}
 
