package classes;

public class User implements Comparable<User>{

    private Integer id;
    private String userName;
    private String password;
    private String email;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.userName = userBuilder.userName;
        this.password = userBuilder.password;
        this.email = userBuilder.email;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public static class UserBuilder {
        private Integer id;
        private String userName;
        private String password;
        private String email;

        public  UserBuilder setUserId(Integer id){
            this.id = id;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }

    @Override
    public int compareTo(User o) {
        if(this.userName != null && o.userName != null){
            int compareUserName = this.userName.compareTo(o.userName);
            if (compareUserName != 0) {
                return compareUserName;
            }
        }

        if(this.password != null && o.password != null){
            int comparePassword = this.password.compareTo(o.password);
            if (comparePassword != 0) {
                return comparePassword;
            }
        }

        if(this.email != null && o.email != null){
            return this.email.compareTo(o.email);
        }

        return 0;
    }

    @Override
    public String toString() {
        return "User [" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ']';
    }
}
