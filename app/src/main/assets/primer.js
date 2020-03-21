
let _requestAnimationFrameGlobalCallBack;
const window = this;
var requestAnimationFrame = (fn)=>{
    if (_requestAnimationFrameGlobalCallBack===undefined) _requestAnimationFrameGlobalCallBack = fn;
};
var Canvas = function(){
    this.width = 800;
    this.height = 600;
    this.style = {};
    this.getContext = (val)=>{
        return _globalGL;
    };
    this.setAttribute = ()=>{};
    this.addEventListener = ()=>{};
};
var Document = function(){
    this.canvas = new Canvas();
    this.createElement = function(val){
        if (val==='canvas') return new Canvas();
    };
    this.getElementById = function(val){
        return this.canvas;
    };
    this.querySelector = function(val){
        return this.canvas;
    };
    this.body = {
        appendChild:()=>{}
    }
    this.addEventListener = ()=>{};
};
const document = new Document();
window.document = document;
const navigator = {
    platform: ''
};
window.innerWidth = 800;
window.innerHeight = 600;
window.addEventListener = ()=>{};

window.performance = {
    now: function(){return new Date().getTime()}
}



