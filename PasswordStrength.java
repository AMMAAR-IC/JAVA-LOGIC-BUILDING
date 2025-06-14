public class PasswordStrength {
    public static String checkStrength(String pass) {
        boolean hasUpper = pass.matches(".*[A-Z].*");
        boolean hasLower = pass.matches(".*[a-z].*");
        boolean hasDigit = pass.matches(".*\\d.*");
        boolean hasSymbol = pass.matches(".*[^a-zA-Z0-9].*");

        int score = 0;
        if (pass.length() >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        return switch (score) {
            case 5 -> "Strong";
            case 4 -> "Medium";
            case 3 -> "Weak";
            default -> "Very Weak";
        };
    }

    public static void main(String[] args) {
        System.out.println(checkStrength("Ammaar@123")); // Strong
    }
}
