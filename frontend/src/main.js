import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import axios from "axios";
import store from "./store";
import { VueCookies } from "vue-cookies";
import { gsap } from "gsap";
import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { far } from "@fortawesome/free-regular-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import Paginate from "vuejs-paginate-next";

library.add(fas);
library.add(far);
library.add(fab);

const app = createApp(App);

// [axios / http 통신]
app.config.globalProperties.$axios = axios;

// 폰트 어썸
app.component("font-awesome-icon", FontAwesomeIcon);

// 라우터
app.use(router);

// content story 부분 라이브러리 -> gsap
app.use(gsap);

// pagination 라이브러리
app.use(Paginate);

// vuex 사용
app.use(store);

// cookie 사용
app.use(VueCookies);

app.mount("#app");
