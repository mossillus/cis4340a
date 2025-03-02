/*****************************************************************************
* Rule 03. Numeric Types and Operations (NUM)
* NUM03-J. Use integer types that can fully represnt the possible range of unsigned data
* Non-compliant code below:
***************************************************************************/

public static int getInteger(DataInputStream is) throws IOException {
  return is.readInt();
}
