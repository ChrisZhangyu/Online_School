/**
 * Created by PanJiaChen on 16/11/18.
 */
import request from "@/utils/request"
/**
 * @param {string} path
 * @returns {Boolean}
 */
export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

/**
 * @param {string} str
 * @returns {Boolean}
 */
export function validPassword(str) {


  // const valid_map = ['admin', 'editor']

  // return valid_map.indexOf(str.trim()) >= 0
  return str.length >= 6
}
