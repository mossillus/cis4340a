/********************************************************************************************************
* Rule 09. Locking (LCK)
* LCK07-J. Ensure actively held locks are released on exceptional conditions
* Non-compliant code:
public final class Client {
  private final Lock lock = new ReentrantLock();
 
  public void doSomething(File file) {
    InputStream in = null;
    try {
      in = new FileInputStream(file);
      lock.lock();
 
      // Perform operations on the open file
 
      lock.unlock();
    } catch (FileNotFoundException x) {
      // Handle exception
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException x) {
          // Handle exception
        } 
      }
    }
  }
}
* Compliant Code:
********************************************************************************************************/
public final class Client {
  private final Lock lock = new ReentrantLock();
 
  public void doSomething(File file) {
    InputStream in = null;
    lock.lock();
    try {
      in = new FileInputStream(file);
      // Perform operations on the open file
    } catch (FileNotFoundException fnf) {
      // Forward to handler
    } finally {
      lock.unlock();
 
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          // Forward to handler
        }
      }
    }
  }
}
