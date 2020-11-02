public class Task1 {

    private static final String strPattern = "+%s+%s+-+-+-+-+";
    private static final String TEXT = "I am Java Developer";

    /*
     *   *************
     *   * I         *
     *   * am        *
     *   * Java      *
     *   * Developer *
     *   *************
     */

    /**
     * Реализовать функцию вывода на консоль текста в параметре TEXT в формате указанном выше
     */
    public static void printFormattedText() {
        String[] array = TEXT.split(" ");

        Optional<String> optMax = Stream.of(array).max((a, b) -> a.length() > b.length() ? 1 : -1);
        if(optMax.isPresent()){
            String strMax = optMax.get();
            int maxLengthIfString = strMax.length() + 4;
            StringBuilder strMaxLine = new StringBuilder();
            for(int i = 0; i < maxLengthIfString; i++){
                strMaxLine.append('*');
            }

            System.out.println(strMaxLine);

            for (String s : array) {
                StringBuilder currentString = new StringBuilder("* " + s);

                int numberOfSpaces = strMaxLine.length() - currentString.length() - 1;

                for (int j = 0; j < numberOfSpaces; j++) {
                    currentString.append(" ");
                }
                currentString.append("*");

                System.out.println(currentString);

            }
            System.out.println(strMaxLine);

        }
    }

    public static void main(String[] args) {
        printFormattedText();
    }
}
