package hr.tel.fer.lab1.logging;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {

    private static final Pattern LINE_PATTERN = Pattern.compile("(.*?)\\s\\[(.*?)\\]\\s(.*?)\\s(.*?)\\s(.*?)\\s(.*?)\\s(\\\".*?\\\")");

    Map<String, Object> fieldNameToValue = new HashMap<>();

    public LogLine(String line){
        Matcher m = LINE_PATTERN.matcher(line);
        if ( m.find() ) {
            fieldNameToValue.put("IP", new IP(m.group(1)));
            fieldNameToValue.put("DATETIME", m.group(2));
            fieldNameToValue.put("METHOD", m.group(3));
            fieldNameToValue.put("PATH", m.group(4));
            fieldNameToValue.put("VERSION", m.group(5));
            fieldNameToValue.put("STATUS", m.group(6));
            fieldNameToValue.put("CLIENT", m.group(7));
        }
    }

    public boolean equals(String fieldName, Object value){
        return fieldNameToValue.containsKey(fieldName) ? fieldNameToValue.get(fieldName).equals(value) : value == null;
    }

    @Override
    public String toString(){
        return "IP: " + fieldNameToValue.get("IP") + ", " +
                "DATETIME: " + fieldNameToValue.get("DATETIME") + ", " +
                "METHOD: " + fieldNameToValue.get("METHOD") + ", " +
                "PATH: " + fieldNameToValue.get("PATH") + ", " +
                "VERSION: " + fieldNameToValue.get("VERSION") + ", " +
                "STATUS: " + fieldNameToValue.get("STATUS") + ", " +
                "CLIENT: " + fieldNameToValue.get("CLIENT") + ", ";
    }

    /**
     * Class representing an IP address, used to easily match incomplete IP
     * addresses where the missing values are represented by x.
     *
     * The equals method is expanded to work properly with both String and IP type arguments.
     *
     * Example: A call to the equals method of a IP object whose ip field value is
     * "123.233.132.5" with an argument of "123.xxx.xx2.x" will return true.
     */
    private class IP implements CharSequence {

        String ip;

        public IP(String ip){
            this.ip = ip;
        }

        @Override
        public int length(){
            return ip.length();
        }

        @Override
        public char charAt(int index){
            return ip.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end){
            return ip.subSequence(start, end);
        }

        @Override
        public String toString(){
            return ip;
        }

        @Override
        public boolean equals(Object o){
            if ( this == o ) return true;
            if ( o == null ) return false;

            if ( o.getClass() == getClass() ){
                return ip.matches(((IP)o).ip.replace(".", "\\.").replace('x','.'));
            }

            if ( o.getClass() == ip.getClass() ){
                return ip.matches(((String)o).replace(".", "\\.").replace('x','.'));
            }
            return false;
        }

        @Override
        public int hashCode(){

            return ip.hashCode();
        }
    }

}
