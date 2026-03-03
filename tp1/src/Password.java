import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Password {
    /**
     * Hashes the provided password using the SHA-256 algorithm.
     * 
     * @param password the password to be hashed
     * @return a hexadecimal string representing the hashed password
     * @throws RuntimeException if the SHA-256 algorithm is not available
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Attempts a brute-force attack to find the 6-digit number
     * 
     * @param targetHash the target hash to match
     * @return the 6-digit number that matches, or null if no match is found
     */
    public static String bruteForce6Digit(String targetHash) {

        // Code here
        for (int nombre = 0; nombre < 1000000; nombre++) {
            String nombres = hashPassword(String.format("%06d", nombre));
            if(Objects.equals(nombres, (targetHash))){
                return String.format("%06d", nombre);
            }
        }
        return null;
    }

    /**
     * Checks if the given password is strong according to the following criteria:
     * 
     * <ul>
     * <li>Minimum length of 12 characters</li>
     * <li>At least one uppercase letter</li>
     * <li>At least one lowercase letter</li>
     * <li>At least one digit</li>
     * <li>No whitespace characters</li>
     * </ul>
     * 
     * @param password the password to check
     * @return true if the password is strong, false otherwise
     */
    public static boolean isStrongPassword(String password) {

        // Code here 
        /*Il a au moins 12 caractères
✅ Il contient au moins une lettre majuscule
✅ Il contient au moins une lettre minuscule
✅ Il contient au moins un chiffre
❌ Il ne contient pas d'espace blanc */

        /*
    Character.isUpperCase(<char>)
    Character.isDigit(<char>)
    Character.isWhitespace(<char>)
 */ 
        Integer maj =0 ;
        Integer min = 0;
        Integer dig = 0;
        Integer space = 0;
        for (int i = 0; i < password.length(); i++) {
            char lettre = password.charAt(i);
            if (Character.isUpperCase(lettre)){
                maj = 1;
            }
            if (Character.isLowerCase(lettre)){
                min = 1;
            }
            if (Character.isDigit(lettre)){
                dig = 1;
            }
            if (Character.isWhitespace(lettre)){
                space = 1;
            }
            if (password.length() >= 12 && maj==1 && min == 1 && dig == 1 && space!=1){
                return true;
            }
        }
        return false;
        
    }

    /**
     * Checks the strength of multiple passwords and stores the results in a
     * HashMap.
     *
     * @param passwords An ArrayList of passwords to be checked.
     * @return A HashMap where each password is mapped to a Boolean value:
     *         true if the password is strong, false otherwise
     */
    public static HashMap<String, Boolean> checkPasswordsList(ArrayList<String> passwords) {

        // Code here
        HashMap<String, Boolean> securite = new HashMap<>();
        for (String motdepasse : passwords){
            Boolean force = isStrongPassword(motdepasse);
            securite.put(motdepasse,force);
        }

        return securite;
    }

    /**
     * Generates a secure random password with at least:
     * <ul>
     * <li>1 uppercase letter</li>
     * <li>1 lowercase letter</li>
     * <li>1 digit</li>
     * <li>1 special character</li>
     * </ul>
     * 
     * @param nbCar The desired length of the password (minimum 4).
     * @return A randomly generated password that meets the security criteria.
     */
    public static String generatePassword(int nbCar) {

        // Code here
        if (nbCar < 4){
            return null;
        }

        SecureRandom random = new SecureRandom();
        List<String> special = new ArrayList<>();
        special.addAll(List.of("&","!","?","§","#","$","£",";"));
        List<String> lettre = new ArrayList<>();
        lettre.addAll(List.of("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        List<String> lettrem = new ArrayList<>();
        lettrem.addAll(List.of("a","z","e","r","t","y","u","i","o","p","q","s","d","f","g","h","j","k","l","m","w","x","c","v","b","n"));
        List<String> nombre = new ArrayList<>();
        nombre.addAll(List.of("1","2","3","4","5","6","7","8","9","0"));
        List<String> mdp = new ArrayList<>();
    
        int i1 = random.nextInt(7);
        mdp.add(special.get(i1));
        int i2 = random.nextInt(23);
        mdp.add(lettre.get(i2));
        int i3 = random.nextInt(9);
        mdp.add(nombre.get(i3));
        int i4 = random.nextInt(23);
        mdp.add((lettrem.get(i4)));

        nombre.addAll(lettre);
        nombre.addAll(special);
        nombre.addAll(lettrem);

        for (int i = 4; i < nbCar; i++){
            int j = random.nextInt(64);
            mdp.add((nombre.get(j)));
        }
        Collections.shuffle(mdp);
        String mdp2 = "";
        for (String charac : mdp){
            mdp2 = mdp2 + charac;
        }
        return mdp2;
    }


    public static void main(String[] args) {
        if (args.length == 0) {
            // No arguments provided, running all questions
            for (int i = 1; i <= 4; i++)
                runQuestion(String.valueOf(i));
        } else {
            for (String arg : args) {
                runQuestion(arg);
            }
        }
    }

    private static void runQuestion(String questionNumber) {

        System.out.println("\nQ" + questionNumber + "\n" + "-".repeat(20));
        switch (questionNumber) {
            case "1":
                String HashedPwd = "a97755204f392b4d8787b38d898671839b4a770a864e52862055cdbdf5bc5bee";
                String bruteForcedPwd = bruteForce6Digit(HashedPwd);
                System.out.println(bruteForcedPwd != null ? bruteForcedPwd : "No result found");
                break;

            case "2":
                System.out.println("Abc5          -> " + isStrongPassword("1234"));
                System.out.println("abcdef123456  -> " + isStrongPassword("abcdef123456"));
                System.out.println("AbCdEf123456  -> " + isStrongPassword("AbCdEf123456"));
                System.out.println("AbCdEf 123456 -> " + isStrongPassword("AbCdEf 123456"));
                break;

            case "3":
                ArrayList<String> passwords = new ArrayList<>(
                        List.of("Abc5", "abcdef123456", "AbCdEf123456", "AbCdEf 123456"));
                HashMap<String, Boolean> password_map = checkPasswordsList(passwords);

                if (password_map != null) {
                    for (Map.Entry<String, Boolean> entry : password_map.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }
                break;

            case "4":
                System.out.println("Generated password: " + generatePassword(50));
                break;

            default:
                System.out.println("Invalid question number: " + questionNumber);
        }
    }

}
