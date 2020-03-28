--- 获取key
local key = KEYS[1]
local num = redis.call("get", key)
--- 如果redis找不到这个key就去插入
if tonumber(num) > 0 then
    --- 如果插入成功，就去设置过期值
    if redis.call("decr", key) then
    end
    return "1"
else
    return "0"
end
