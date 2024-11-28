package classes;

public class Bus implements Comparable<Bus> {
    private Integer id;
    private String number;
    private String model;
    private Integer mileage;

    private Bus(BusBuilder busBuilder) {
        this.id = busBuilder.id;
        this.number = busBuilder.number;
        this.model = busBuilder.model;
        this.mileage = busBuilder.mileage;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getMileage() {
        return this.mileage;
    }

    public static class BusBuilder {
        private Integer id;
        private String number;
        private String model;
        private Integer mileage;

        public BusBuilder setBusId(Integer id) {
            this.id = id;
            return this;
        }

        public BusBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }

    @Override
    public int compareTo(Bus o) {
        if (this.number != null && o.number != null) {
            int compareNumber = this.number.compareTo(o.number);
            if (compareNumber != 0) {
                return compareNumber;
            }
        }

        if (this.model != null && o.model != null) {
            int compareModel = this.model.compareTo(o.model);
            if (compareModel != 0) {
                return compareModel;
            }
        }

        if (this.mileage != null && o.mileage != null) {
            return this.mileage.compareTo(o.mileage);
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Bus [" +
                "number='" + number + '\'' +
                ", model=" + model +
                ", mileage='" + mileage + '\'' +
                ']';
    }
}
