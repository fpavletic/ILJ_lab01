package hr.tel.fer.lab1.server;

import hr.tel.fer.lab1.logging.LogLine;

import java.util.List;
import java.util.function.Predicate;

public class LogRequestContainer {

    private List<Predicate<LogLine>> conditions;
    private int count;

    public LogRequestContainer(List<Predicate<LogLine>> conditions, int count){
        this.conditions = conditions;
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public List<Predicate<LogLine>> getConditions(){
        return conditions;
    }
}
