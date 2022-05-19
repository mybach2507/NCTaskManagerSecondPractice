package ua.edu.sumdu.j2se.mykyta.tasks;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.omg.Messaging.SyncScopeHelper;

public class Task
{
    private int time;
    private String title;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;


    // конструює неактивну задачу, яка
    //виконується у заданий час без повторення із заданою назвою
    public Task(String title, int time)
    {
        active = false;
        this.repeat = false;
        this.time = time;
        this.title = title;
    }


    //конструює
    //неактивну задачу, яка виконується у заданому проміжку часу
    //(і початок і кінець включно) із
    //заданим інтервалом і має задану назву
    public Task(String title, int start, int end, int interval)
    {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        active=false;
        repeat = true;
    }



    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    //читування та встановлення стану задачі


    public boolean isActive() {
       // System.out.println("this task is "+ active);
        return active;
    }



    public void setActive(boolean active) {
        this.active = active;
    }

    //Методи для зчитування та зміни
    // часу виконання для задач, що НЕ повторюються
    public int getTime()
    {
        if(repeat)
        {
            return start;
        }
            return time;
    }

    public void setTime(int time)
    {
        if(repeat)
        {
            repeat = false;
        }
        this.time = time;
    }

    //Методи для зчитування та зміни
    // часу виконання для задач, що повторюються
    public int getStartTime()
    {
        if(repeat) {
            return start;
        }
        return time;
    }
    public int getEndTime()
    {
        if(repeat==false) {
            return time;
        }
            return end;
    }



    //якщо задача не повторюється метод має
    //повертати 0

    public int getRepeatInterval()
    {
        if(repeat) {
            return interval;
        }
        return 0;
    }
    void setTime(int start, int end, int interval){
        if(repeat==false)
        {
            repeat = true;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }
    public boolean isRepeated()
    {
        return repeat;
    }


    ///////
    // повертає час наступного
    //
    // виконання задачі після вказаного часу
    public int nextTimeAfter(int current) {
        if (current < getStartTime() && isActive() && isRepeated()) {
            return getStartTime();
        } else if (current < getTime() && isActive() && !isRepeated()){
            return getTime();
        } else if (isActive() && isRepeated() && current >= getStartTime() && current < getEndTime()) {
            return nextRepeative(current);
        } return -1;
    }
    public  int nextRepeative (int current) {
        int countTimes;
        for (countTimes = this.start; countTimes < this.end; countTimes += this.interval) {
            if (countTimes >= current) {
                System.out.print("the next repeating is at ");
                break;
            }
        }
        return countTimes;
    }
}
