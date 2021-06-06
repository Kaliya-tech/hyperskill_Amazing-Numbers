class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder string = new StringBuilder();
        char letters = 'A';

        for (int i = 0; i < 27; i++) {
            if (letters == 'Z') {
                string.append(letters);
                break;
            } else {
                string.append(letters);
                string.append(" ");
                letters++;
            }
        }
        return string;
    }


    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}