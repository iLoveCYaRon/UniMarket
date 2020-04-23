package moe.sui.unimarket.datamodel;

public class Customer {

    /**
     * id : 4
     * date_created : 2020-04-22T22:12:43
     * date_created_gmt : 2020-04-22T14:12:43
     * date_modified : 2020-04-22T22:12:45
     * date_modified_gmt : 2020-04-22T14:12:45
     * email : customer@example.com
     * first_name :
     * last_name :
     * role : customer
     * username : Customer
     * billing : {"first_name":"","last_name":"","company":"","address_1":"","address_2":"","city":"","postcode":"","country":"","state":"","email":"","phone":""}
     * shipping : {"first_name":"","last_name":"","company":"","address_1":"","address_2":"","city":"","postcode":"","country":"","state":""}
     * avatar_url : https://secure.gravatar.com/avatar/592fc57ef0b254235cfa5977bccfd34a?s=96&d=mm&r=g
     */

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String role;
    private String username;
    private BillingBean billing;
    private ShippingBean shipping;
    private String avatar_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BillingBean getBilling() {
        return billing;
    }

    public void setBilling(BillingBean billing) {
        this.billing = billing;
    }

    public ShippingBean getShipping() {
        return shipping;
    }

    public void setShipping(ShippingBean shipping) {
        this.shipping = shipping;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


    public static class BillingBean {
        /**
         * first_name :
         * last_name :
         * company :
         * address_1 :
         * address_2 :
         * city :
         * postcode :
         * country :
         * state :
         * email :
         * phone :
         */

        private String first_name;
        private String last_name;
        private String company;
        private String address_1;
        private String address_2;
        private String city;
        private String postcode;
        private String country;
        private String state;
        private String email;
        private String phone;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getAddress_1() {
            return address_1;
        }

        public void setAddress_1(String address_1) {
            this.address_1 = address_1;
        }

        public String getAddress_2() {
            return address_2;
        }

        public void setAddress_2(String address_2) {
            this.address_2 = address_2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class ShippingBean {
        /**
         * first_name :
         * last_name :
         * company :
         * address_1 :
         * address_2 :
         * city :
         * postcode :
         * country :
         * state :
         */

        private String first_name;
        private String last_name;
        private String company;
        private String address_1;
        private String address_2;
        private String city;
        private String postcode;
        private String country;
        private String state;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getAddress_1() {
            return address_1;
        }

        public void setAddress_1(String address_1) {
            this.address_1 = address_1;
        }

        public String getAddress_2() {
            return address_2;
        }

        public void setAddress_2(String address_2) {
            this.address_2 = address_2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
