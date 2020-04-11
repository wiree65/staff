<template>
    <div>
        asd
          <v-flex
                xs12
                sm6
                lg4
                v-for="data in data"
                :key="data.id"
            >
                <p :data="data"></p>
            </v-flex>
    </div>
</template>
<script>
    import equipment from "@/axios/axios";
    export default {
        data() {
            return {
                data: null
            };
        },
        async mounted() {
            const response = await equipment.get("/api/Staffs");
            console.log(response.data);
            this.data = response.data;
        }
    };
</script>