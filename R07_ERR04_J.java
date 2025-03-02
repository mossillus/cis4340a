/*******************************************************************************************************
* Rule 07. Exceptional Behavior (ERR)
* ERR04-J. DO not complete aabruptly from a finally block
* Non-compliant Code:
class TryFinally {
  private static boolean doLogic() {
    try {
      throw new IllegalStateException();
    } finally {
      System.out.println("logic done");
      return true;
    }
  }
}
* Compliant Code:
*******************************************************************************************************/
class TryFinally {
  private static boolean doLogic() {
    try {
      throw new IllegalStateException();
    } finally {
      System.out.println("logic done");
    }
    // Any return statements must go here;
    // applicable only when exception is thrown conditionally
  }
}
