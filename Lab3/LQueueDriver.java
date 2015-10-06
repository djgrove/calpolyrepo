import java.util.*;

public class LQueueDriver {

	public static void main(String[] args) {
		LQueue<Integer> queue = new LQueue<Integer>();
	
		System.out.println("Choose one of the following operations:");
		System.out.println("-- enqueue/add (enter the letter a)");
		System.out.println("-- dequeue/delete (enter the letter d)");
		System.out.println("-- check if the queue is empty (enter the letter e)");
		System.out.println("-- quit (enter the letter q)");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;

		while(run)
		{
			char result = ' ';
			String input = scanner.nextLine();
			if(input.length() > 0)
			{
				result = input.charAt(0);
			}
			
			switch(result)
			{
				case 'a': 
					System.out.println("enqueue: ");
					if(!scanner.hasNextInt())
					{
						System.out.println("Invalid value"); // Invalid choice is also outputted | FIX
						break;
					}
					else
					{
						int toQueue = scanner.nextInt();
						queue.enqueue(toQueue);
						System.out.println(toQueue + " enqueued");
						break;
					}
					
				case 'd': 
					try
					{
						System.out.println(queue.dequeue() + " dequeued");
					}
					catch(Exception e)
					{
						System.out.println("Invalid operation: queue is empty.");
					}
					break;

				case 'e': 
					if(queue.isEmpty())
					{
						System.out.println("empty");
					}
					else
					{
						System.out.println("not empty");
					}
					break;

				case 'q': 
					System.out.println("quitting");
					run = false;
					break;
			
				default: 
					// if((result != 'q') || (result != 'e') || (result != 'a') || (result != 'd'))
					// {
						System.out.println("Invalid choice");
						break;
					//}
			}
		}
		scanner.close();
		// remainder of queue is output
		while(!queue.isEmpty())
		{
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println("\nGoodbye!");		
	}
}
