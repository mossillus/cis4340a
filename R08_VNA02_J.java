/*********************************************************************************************************
* Rule 08. Visibility and Atomicity (VNA)
* VNA02-J. Ensure that compound operations on shared vvariables are atomic
* Non-compliant Code:
final class Flag {
  private boolean flag = true;
 
  public void toggle() {  // Unsafe
    flag = !flag;
  }
 
  public boolean getFlag() { // Unsafe
    return flag;
  }
}
* Compliatn Code:
*********************************************************************************************************/
final class Flag {
  private boolean flag = true;
 
  public synchronized void toggle() {
    flag ^= true; // Same as flag = !flag;
  }
 
  public synchronized boolean getFlag() {
    return flag;
  }
}
