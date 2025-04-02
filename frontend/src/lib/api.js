import { PUBLIC_API_BASE } from '$env/static/public';

console.log(PUBLIC_API_BASE); // http://localhost:8080/api/v1

const fetchAPI = async (resource, options = {}) => {
    const sep = (resource.startsWith("/")) ? '' : '/';
    const response = await fetch(`${PUBLIC_API_BASE}${sep}${resource}`, options);
    if (!response.ok) {
        throw new Error(response.statusText);
    }
    return await response.json();
};

export const api = {
    all: async (resource, options = {}) =>
        fetchAPI(resource, { ...options, method: 'GET' }),

    one: async (resource, slug, options = {}) =>
        fetchAPI(`${resource}/${slug}`, { ...options, method: 'GET' }),

    create: async (resource, data, options = {}) =>
        fetchAPI(resource, {
            ...options,
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                ...(options.headers || {})
            },
            body: data
        }),

    update: async (resource, slug, data, options = {}) =>
        fetchAPI(`${resource}/${slug}`, {
            ...options,
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                ...(options.headers || {})
            },
            body: data
        }),

    delete: async (resource, slug, options = {}) =>
        fetchAPI(`${resource}/${slug}`, {
            ...options,
            method: 'DELETE'
        }),
};
