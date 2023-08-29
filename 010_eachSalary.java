import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;

class Employee
{
	String designation;
	int salary;

	Employee(String designation, int salary)
	{
		this.designation = designation;
		this.salary = salary;
	}

	String getDesignation()
	{
		return this.designation;
	}

	int getSalary()
	{
		return this.salary;
	}
}


class Solution
{
	public static void main(String[] args)
	{
		Employee e1 = new Employee("Manager",200);
		Employee e2 = new Employee("Developer",100);
		Employee e3 = new Employee("Manager",300);
		Employee e4 = new Employee("Tester",400);
		Employee e5 = new Employee("Developer",800);

		Stream<Employee> s = Stream.of(e1,e2,e3,e4,e5);

		Map<String,Integer> map = s
					.collect(Collectors.groupingBy(
						Employee::getDesignation,
						Collectors.summingInt(Employee::getSalary)
					));

		for(Map.Entry<String,Integer> m : map.entrySet())
		{
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}
}
