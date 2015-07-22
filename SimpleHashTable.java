/*
 * implementing simple hash table, regardless of hash-full situation
 *
 * Martin.Xia
 */
public class SimpleHashTable {
      private int TABLE_SIZE;
      private int size; 
      private LinkedHashEntry[] table;
   
       /* Constructor */
      public SimpleHashTable(int ts) {
          size = 0;
          TABLE_SIZE = ts;
          table = new LinkedHashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
              table[i] = null;
      } 
      /* Function to get number of key-value pairs */
      public int getSize() {
          return size;
      }
      /* Function to clear hash table */
      public void clean() {
          for (int i = 0; i < TABLE_SIZE; i++)
              table[i] = null;
          size = 0;
      }

      /* function to retrieve value from the table according to key */
      public int get(String key) {
          int index = findIndex(key);
          return table[index] == null ? -1 : table[index].getValue();
      }

      /* function to add value to the table */
      public void put(String key, int value) {
          table[findIndex(key)] = new HashEntry(key, value);
          size++;
      }

      /* function to remove value to the table */
      public void remove(String key) {
          table[findIndex(key)] = null;
          size--;
      }

      /* value to create the Hash code from he name entered, basically converting name to ASCII */
      private int calculateHashCode(String key) {
          int mod = key.hashCode() % TABLE_SIZE;
          return mod < 0 ? mod + TABLE_SIZE : mod;
      }

      private int findIndex(String key) {
          int index = calculateHashCode(key);
          while (table[index] != null && !table[index].getKey().equals(key)) {
              index = (index + 1) % TABLE_SIZE;
          }
          return index;
      }
}
