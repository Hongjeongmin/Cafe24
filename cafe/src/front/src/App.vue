<template>
  <div class="wrapper">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      loginUser: {}
    }
  },
  mounted() {
  },
  methods: {
    async loginUserInfo() {
      const ret = await fetch("api/loginUserInfo")
          .then(response => response.json())
          .catch(() => {

            return 'api 실패';
          });
      console.log(ret.data);

      this.loginUser = ret.data;
    }
  }
}

</script>
<style>
</style>
