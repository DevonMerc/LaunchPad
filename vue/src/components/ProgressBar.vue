<template>
<div id="app">
  <div class="shell">
    <div class="bar" :style="{ width: (funding/goal)*100 + '%'}">
      <!-- <span>${{ funding }}</span> -->
    </div>
  </div>
</div>
</template>

<script>
export default{
    props: ['funding', 'goal']
}
</script>

<style scoped>
#app {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.shell {
  height: 10px;
  width: 100%;
  border: 1px solid #db8605;
  border-radius: 13px;
  padding: 3px;
}

.bar {
  background: linear-gradient(to right, #f5d314, #e0860f);
  height: 10px;
  border-radius: 9px;
}
</style>