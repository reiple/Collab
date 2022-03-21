package collab;

import java.util.List;

public abstract class AbstractSecondOption {
    protected static final int COL = 0;
    protected static final int VAL= 1;
    protected List<String> optionArgument;
    public AbstractSecondOption(List<String> optionArgument){
        this.optionArgument = optionArgument;
    }
    public String getSearchColumn(){
        return optionArgument.get(COL);
    }
    public String getSearchValue(){
        return optionArgument.get(VAL);
    }
    abstract public List<Employee> getFilteredList(EmployeeDAO DAO);
}
